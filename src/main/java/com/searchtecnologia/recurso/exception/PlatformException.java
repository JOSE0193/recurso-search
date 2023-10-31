package com.searchtecnologia.recurso.exception;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@Getter
@ToString
public class PlatformException extends RuntimeException {

    Optional<HttpStatus> status;

    public PlatformException(String message) {
        super(message);
        this.status = Optional.empty();
    }

    public PlatformException(String message, Optional<HttpStatus> status) {
        super(message);
        this.status = status;
    }

    public PlatformException(String message, Throwable cause) {
        super(message, cause);
        this.status = Optional.empty();
    }

    public PlatformException(String message, Throwable cause, Optional<HttpStatus> status) {
        super(message, cause);
        this.status = status;
    }

    public PlatformException(Throwable cause) {
        super(cause);
        this.status = Optional.empty();
    }

    public PlatformException(Throwable cause, Optional<HttpStatus> status) {
        super(cause);
        this.status = status;
    }

    public PlatformException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.status = Optional.empty();
    }

    public PlatformException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Optional<HttpStatus> status) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.status = status;
    }
}
