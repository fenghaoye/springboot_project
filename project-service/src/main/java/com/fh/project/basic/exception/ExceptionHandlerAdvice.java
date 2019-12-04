package com.fh.project.basic.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import java.io.PrintWriter;
import java.io.StringWriter;


@ControllerAdvice
@ResponseBody
public class ExceptionHandlerAdvice {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(BusinessException.class)
    public String exception(BusinessException businessException, WebRequest request) {
        StringWriter exceptionFormat = new StringWriter();
        businessException.printStackTrace(new PrintWriter(exceptionFormat, true));
        return businessException.getMessage();

    }

    @ExceptionHandler(Exception.class)
    public String exception(Exception exception, WebRequest request) {
        StringWriter exceptionFormat = new StringWriter();
        exception.printStackTrace(new PrintWriter(exceptionFormat, true));
        exception.printStackTrace();
        return exception.getMessage();
    }
}
