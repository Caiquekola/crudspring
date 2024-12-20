package com.caiquekola.CRUDapi.services.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DataBindingViollationException extends DataIntegrityViolationException {

    public DataBindingViollationException(String message) {
        super(message);
    }
}
