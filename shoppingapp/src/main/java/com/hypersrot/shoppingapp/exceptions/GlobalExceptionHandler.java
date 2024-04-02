package com.hypersrot.shoppingapp.exceptions;

import com.sun.nio.sctp.NotificationHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;
import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorDetails> noHandlerFoundException(WebRequest webRequest, Exception e) {
        ErrorDetails ed = new ErrorDetails();
        ed.setMessage(e.getLocalizedMessage());
        ed.setTimeStamp(LocalDateTime.now());
        ed.setUri(webRequest.getDescription(false));

        return ResponseEntity.internalServerError().body(ed);
    }

    @ExceptionHandler(CouponException.class)
    public ResponseEntity<ErrorDetails> couponException(WebRequest webRequest, CouponException ce) {
        ErrorDetails ed = new ErrorDetails();
        ed.setMessage(ce.getMessage());
        ed.setTimeStamp(LocalDateTime.now());
        ed.setUri(webRequest.getDescription(false));

        return ResponseEntity.badRequest().body(ed);
    }

    @ExceptionHandler(OrderException.class)
    public ResponseEntity<ErrorDetails> orderException(WebRequest webRequest, OrderException oe) {
        ErrorDetails ed = new ErrorDetails();
        ed.setMessage(oe.getMessage());
        ed.setTimeStamp(LocalDateTime.now());
        ed.setUri(webRequest.getDescription(false));

        return ResponseEntity.badRequest().body(ed);
    }

    @ExceptionHandler(PaymentException.class)
    public ResponseEntity<ErrorDetails> paymentException(WebRequest webRequest, PaymentException pe) {
        ErrorDetails ed = new ErrorDetails();
        ed.setMessage(pe.getMessage());
        ed.setTimeStamp(LocalDateTime.now());
        ed.setUri(webRequest.getDescription(false));

        return ResponseEntity.badRequest().body(ed);
    }

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<ErrorDetails> productException(WebRequest webRequest, ProductException prE) {
        ErrorDetails ed = new ErrorDetails();
        ed.setMessage(prE.getMessage());
        ed.setTimeStamp(LocalDateTime.now());
        ed.setUri(webRequest.getDescription(false));

        return ResponseEntity.badRequest().body(ed);
    }

    @ExceptionHandler(UserException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public ResponseEntity<ErrorDetails> userException(WebRequest webRequest, UserException ue) {
        ErrorDetails ed = new ErrorDetails();
        if(Objects.isNull(ue))
            ed.setMessage("Bad Request");
        else ed.setMessage(ue.getMessage());
        ed.setTimeStamp(LocalDateTime.now());
        ed.setUri(webRequest.getDescription(false));

        return new ResponseEntity<>(ed, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorDetails> notFoundException(WebRequest webRequest) {
        ErrorDetails ed = new ErrorDetails();
        ed.setTimeStamp(LocalDateTime.now());
        ed.setMessage("Requested link was not found");
        ed.setUri(webRequest.getDescription(false));
        return new ResponseEntity<>(ed, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpClientErrorException.MethodNotAllowed.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ResponseEntity<ErrorDetails> methodNotAllowed(WebRequest webRequest) {
        ErrorDetails ed = new ErrorDetails();
        ed.setTimeStamp(LocalDateTime.now());
        ed.setMessage("Invalid request or not allowed");
        ed.setUri(webRequest.getDescription(false));
        return new ResponseEntity<>(ed, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(HttpServerErrorException.GatewayTimeout.class)
    @ResponseStatus(HttpStatus.GATEWAY_TIMEOUT)
    public ResponseEntity<ErrorDetails> gatewayTimeout(WebRequest webRequest) {
        ErrorDetails ed = new ErrorDetails();
        ed.setTimeStamp(LocalDateTime.now());
        ed.setMessage("Gateway Timeout");
        ed.setUri(webRequest.getDescription(false));
        return new ResponseEntity<>(ed, HttpStatus.GATEWAY_TIMEOUT);
    }
}
