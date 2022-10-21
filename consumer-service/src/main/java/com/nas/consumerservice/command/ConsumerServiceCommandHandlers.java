package com.nas.consumerservice.command;


import com.nas.consumerservice.exception.ConsumerNotFoundException;
import com.nas.consumerservice.service.ConsumerService;
import io.eventuate.tram.commands.consumer.CommandHandlers;
import io.eventuate.tram.commands.consumer.CommandMessage;
import io.eventuate.tram.commands.consumer.CommandReplyToken;
import io.eventuate.tram.sagas.participant.SagaCommandHandlersBuilder;
import io.eventuate.tram.messaging.common.Message;
import org.springframework.beans.factory.annotation.Autowired;

import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withFailure;
import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withSuccess;

public class ConsumerServiceCommandHandlers {


    @Autowired
    private  ConsumerService consumerService;

    public ConsumerServiceCommandHandlers() {

    }

    /*public CommandHandlers commandHandlers() {
        return SagaCommandHandlersBuilder
                .fromChannel("consumerService")
                .onMessage(ValidateOrderByConsumer.class, this::validateOrderForConsumer)
                .build();
    }

    private Message validateOrderForConsumer(CommandMessage<ValidateOrderByConsumer> validateOrderByConsumerCommandMessage, CommandReplyToken commandReplyToken) {
        try {
            consumerService.validateOrderForConsumer(
                    validateOrderByConsumerCommandMessage.getCommand().getConsumerId(),
                    validateOrderByConsumerCommandMessage.getCommand().getOrderTotal());
            return withSuccess();
        } catch (ConsumerNotFoundException e) {
            return withFailure();
        }
    }*/
}
