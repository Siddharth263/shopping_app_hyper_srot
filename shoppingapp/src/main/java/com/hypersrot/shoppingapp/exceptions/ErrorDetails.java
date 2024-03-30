package com.hypersrot.shoppingapp.exceptions;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorDetails {
    private String message;
    private String uri;
    private LocalDateTime timeStamp;
}
