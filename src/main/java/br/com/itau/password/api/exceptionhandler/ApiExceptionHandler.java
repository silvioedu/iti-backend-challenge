package br.com.itau.password.api.exceptionhandler;

import java.time.OffsetDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	private static final String MSG_INVALID_BODY = "Request body is invalid, check syntax error.";

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Problem problem = Problem.builder().status(status.value())
				.title(ProblemTypeEnum.INCOMPREHENSIBLE_MSG.getTitle())
				.detail(MSG_INVALID_BODY)
				.timestamp(OffsetDateTime.now()).build();

		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}

}
