package com.hypersrot.shoppingapp.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

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
    public ResponseEntity<ErrorDetails> userException(WebRequest webRequest, UserException ue) {
        ErrorDetails ed = new ErrorDetails();
        ed.setMessage(ue.getMessage());
        ed.setTimeStamp(LocalDateTime.now());
        ed.setUri(webRequest.getDescription(false));

        return ResponseEntity.badRequest().body(ed);
    }

}
