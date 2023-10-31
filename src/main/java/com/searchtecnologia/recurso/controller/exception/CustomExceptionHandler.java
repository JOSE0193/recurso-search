package com.searchtecnologia.recurso.controller.exception;

import com.searchtecnologia.recurso.controller.exception.dto.ErrorDTO;
import com.searchtecnologia.recurso.exception.PlatformException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.hibernate.validator.internal.engine.path.NodeImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleDefaultException(Exception exception, WebRequest request) {
        ErrorDTO errorDTO = new ErrorDTO(ExceptionUtils.getStackTrace(exception), null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDTO);
    }

    @ExceptionHandler(UndeclaredThrowableException.class)
    public final ResponseEntity<Object> handleUndeclaredThrowableException(UndeclaredThrowableException undeclaredThrowableException, WebRequest request) {
        if (undeclaredThrowableException.getCause() instanceof PlatformException) {
            PlatformException platformException = (PlatformException) undeclaredThrowableException.getCause();
            ErrorDTO errorDTO = new ErrorDTO(platformException.getMessage(), null);
            return ResponseEntity
                    .status(platformException.getStatus().orElse(HttpStatus.INTERNAL_SERVER_ERROR))
                    .body(errorDTO);
        } else {
            ErrorDTO errorDTO = new ErrorDTO(ExceptionUtils.getStackTrace(undeclaredThrowableException), null);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(errorDTO);
        }
    }

    @ExceptionHandler(PlatformException.class)
    public final ResponseEntity<Object> handlePlatformException(PlatformException platformException, WebRequest request) {
        ErrorDTO errorDTO = new ErrorDTO(platformException.getMessage(), null);
        return ResponseEntity
                .status(platformException.getStatus().orElse(HttpStatus.INTERNAL_SERVER_ERROR))
                .body(errorDTO);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> details = ex.getBindingResult().getAllErrors().stream()
                .map(this::handleErrorArgumentNotValid)
                .sorted()
                .collect(Collectors.toList());

        ErrorDTO erroDTO = new ErrorDTO("Erro de validação", details);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(erroDTO);
    }

    private String handleErrorArgumentNotValid(ObjectError error) {
        Path nodes = error.unwrap(ConstraintViolation.class).getPropertyPath();

        Optional<NodeImpl> node = StreamSupport.stream(nodes.spliterator(), false)
                .filter(it -> it.isInIterable())
                .map(it -> (NodeImpl) it)
                .findFirst();

        String prefix = node
                .map(NodeImpl::getParent)
                .map(it -> it + ": ")
                .orElse("");

        return prefix + error.getDefaultMessage();
    }
}