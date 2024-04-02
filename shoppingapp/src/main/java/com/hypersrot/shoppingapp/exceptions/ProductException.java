package com.hypersrot.shoppingapp.exceptions;



public class ProductException extends RuntimeException{
    public ProductException() {
    }

    public ProductException(String message) {
        super(message);
    }
}
