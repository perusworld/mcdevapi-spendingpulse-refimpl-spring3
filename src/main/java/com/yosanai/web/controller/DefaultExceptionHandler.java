package com.yosanai.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mastercard.api.core.exception.ApiException;

@ControllerAdvice
public class DefaultExceptionHandler {
	@ExceptionHandler(ApiException.class)
	public @ResponseBody ApiException apiException(ApiException ex) {
		return ex;
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public void fallback() {
	}
}
