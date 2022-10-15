package com.nas.consumerservice.exception;

public class ConsumerNotFoundException extends RuntimeException{

    public ConsumerNotFoundException(String msg) {
        super(msg);
    }
}
