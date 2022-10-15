package com.nas.consumerservice.controller;


import com.nas.consumerservice.command.ConsumerCommand;
import com.nas.consumerservice.dto.ConsumerDTO;
import com.nas.consumerservice.mapper.ConsumerMapper;
import com.nas.consumerservice.model.Consumer;
import com.nas.consumerservice.service.ConsumerService;
import io.eventuate.tram.events.publisher.ResultWithEvents;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.nas.core.ResourcePaths.CONSUMER;
import static com.nas.core.ResourcePaths.V2;

@RestController
@RequiredArgsConstructor
@RequestMapping(V2 + CONSUMER)
public class ConsumerController {

    private final ConsumerService consumerService;
    private final ConsumerMapper consumerMapper;

    @RequestMapping(method = RequestMethod.POST)
    public ConsumerDTO create(@RequestBody final ConsumerCommand command){
        final ResultWithEvents<Consumer> consumerResultWithEvents = consumerService.create(command);
        return new ConsumerDTO(consumerResultWithEvents.result.getId());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{consumerId}")
    public ResponseEntity<ConsumerDTO> getConsumerById(@PathVariable("consumerId") final String consumerId){
        final Consumer consumer = consumerService.findById(consumerId);
        return ResponseEntity.ok(consumerMapper.toDto(consumer));
    }
}
