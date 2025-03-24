package com.dinesh.usermanagement.web;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dinesh.usermanagement.web.exception.ApiError;
@ControllerAdvice
public class RestRequestExceptionHandler extends ResponseEntityExceptionHandler{
    //Handles the exception for unknown key names in the request
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(final HttpMessageNotReadableException ex,
            final HttpHeaders headers, final HttpStatusCode status, final WebRequest request) {
        return handleExceptionInternal(ex, message(ex, status), headers, status, request);
    }
    
    private ApiError message(final HttpMessageNotReadableException ex, final HttpStatusCode statusCode) {
        String message = (ex.getMessage() == null) ? ex.getClass().getSimpleName(): ex.getMessage();
        String devMessage = ex.getClass().getSimpleName();

        return new ApiError(statusCode.value(), message, devMessage);
    }
}
