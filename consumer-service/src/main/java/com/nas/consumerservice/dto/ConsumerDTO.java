package com.nas.consumerservice.dto;

import com.nas.common.PersonName;


public class ConsumerDTO {
    private String id;
    private PersonName personName;

    public ConsumerDTO(String id) {
        this.id = id;
    }
}
