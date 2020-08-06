package com.orange.brisaEjemplo.exception.handler;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.orange.brisaEjemplo.exception.ExceptionResponse;
import com.orange.brisaEjemplo.exception.generic.BadRequestException;
import com.orange.brisaEjemplo.exception.generic.ConflictException;
import com.orange.brisaEjemplo.exception.generic.NoContentException;
import com.orange.brisaEjemplo.exception.generic.NotFoundException;
import com.orange.brisaEjemplo.exception.generic.UnprocessableException;
import com.orange.brisaEjemplo.logs.CustomLogs;



@ControllerAdvice
public class BrisaExceptionHandler extends ResponseEntityExceptionHandler{
	
	 private static CustomLogs clogger= new CustomLogs();

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({NotFoundException.class})
	@ResponseBody
	public ExceptionResponse notFoundRequest(HttpServletRequest request, Exception exception) {
		return new ExceptionResponse(exception, request.getRequestURI());
	}
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ExceptionHandler({NoContentException.class})
	@ResponseBody
	public void noContentRequest(HttpServletRequest request, Exception exception) {
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({
		BadRequestException.class,
		org.springframework.dao.DuplicateKeyException.class
	})	
	@ResponseBody
	public ExceptionResponse BadRequest(HttpServletRequest request, Exception exception) {
		return new ExceptionResponse(exception, request.getRequestURI());
	}
	
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	@ExceptionHandler({UnprocessableException.class})
	@ResponseBody
	public ExceptionResponse unprocessableRequest(HttpServletRequest request, Exception exception) {
		return new ExceptionResponse(exception, request.getRequestURI());
	}
	
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler({ConflictException.class,
		org.hibernate.exception.ConstraintViolationException.class})
	@ResponseBody
	public ExceptionResponse conflictRequest(HttpServletRequest request, Exception exception) {
		return new ExceptionResponse(exception, request.getRequestURI());
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({Exception.class})
	@ResponseBody
	public ExceptionResponse fatalErrorInexpectedException(HttpServletRequest request, Exception exception) {
		clogger.error(exception);
		return new ExceptionResponse(exception, request.getRequestURI());
	}
	
	private String getTrace(Exception e) {
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		return sw.toString();
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		clogger.error(getTrace(ex));
		List<String> errorMessages = ex.getBindingResult().getFieldErrors().stream().map( e -> e.getDefaultMessage()).collect(Collectors.toList());
		return new ResponseEntity<>(new ExceptionResponse(ex, errorMessages.toString(), request.getDescription(false)),
				HttpStatus.BAD_REQUEST);
	}
}
