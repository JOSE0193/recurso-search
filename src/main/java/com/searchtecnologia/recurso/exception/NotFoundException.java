package com.searchtecnologia.recurso.exception;

import org.springframework.http.HttpStatus;

import java.util.Optional;

public class NotFoundException extends PlatformException {

    public NotFoundException(String message) {
        super(message);
        this.status = Optional.of(HttpStatus.NOT_FOUND);
    }
}