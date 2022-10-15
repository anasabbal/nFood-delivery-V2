package com.nas.consumerservice.mapper;


import com.nas.consumerservice.dto.ConsumerDTO;
import com.nas.consumerservice.model.Consumer;
import org.mapstruct.Mapper;

@Mapper
public abstract class ConsumerMapper {
    public abstract ConsumerDTO toDto(Consumer consumer);
}
