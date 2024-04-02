package com.hypersrot.shoppingapp.exceptions;



public class OrderException extends RuntimeException{
    public OrderException() {
    }

    public OrderException(String message) {
        super(message);
    }
}
