package com.hypersrot.shoppingapp.exceptions;



public class CouponException extends RuntimeException{
    public CouponException() {
    }

    public CouponException(String message) {
        super(message);
    }
}
