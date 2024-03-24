package com.pe.relari.employee.exception;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {

    private final ErrorCategory catalog;
    private final Throwable detail;

    protected ApiException(ErrorCategory catalog) {
        super("");
        this.catalog = catalog;
        this.detail = null;
    }

    protected ApiException(ErrorCategory catalog, Throwable detail) {
        super("");
        this.catalog = catalog;
        this.detail = detail;
    }

    protected ApiException(ErrorCategory catalog, String message) {
        super(message);
        this.catalog = catalog;
        this.detail = null;
    }

    public static ApiException of(ErrorCategory catalog) {
        return new ApiException(catalog);
    }

    public static ApiException of(ErrorCategory catalog, Throwable throwable) {
        return new ApiException(catalog, throwable);
    }

    public static ApiException of(ErrorCategory catalog, String message) {
        return new ApiException(catalog, message);
    }

}
