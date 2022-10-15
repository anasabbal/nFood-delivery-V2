package com.nas.consumerservice.exception;

public class ConsumerNotFoundException extends RuntimeException{


    public ConsumerNotFoundException() {
    }

    public ConsumerNotFoundException(String msg) {
        super(msg);
    }
}
