package com.mypractice.oauth.server.oauthserver.exception;

import com.mypractice.oauth.server.oauthserver.dto.ErrorDetails;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UniqueConstraintException.class)
    public ResponseEntity<ErrorDetails> genericException(final UniqueConstraintException genericException) {
        return new ResponseEntity<>(ErrorDetails.builder().errorCode(HttpStatus.UNPROCESSABLE_ENTITY.value())
                .errorMessage(genericException.getMessage()).date(new Date()).build(), HttpStatus.UNPROCESSABLE_ENTITY);
    }
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ErrorDetails> notFoundException(final ResourceNotFound resourceNotFound) {
        return new ResponseEntity<>(ErrorDetails.builder().errorCode(HttpStatus.NOT_FOUND.value())
                .errorMessage(resourceNotFound.getMessage()).date(new Date()).build(), HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException notValidException,
                                                                  final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        final Map<String, String> errors = notValidException.getBindingResult()
                .getAllErrors().stream()
                .collect(Collectors.toMap(error -> ((FieldError) error).getField(), DefaultMessageSourceResolvable::getDefaultMessage, (a, b) -> b));
        return new ResponseEntity<>(errors, status);
    }
}
