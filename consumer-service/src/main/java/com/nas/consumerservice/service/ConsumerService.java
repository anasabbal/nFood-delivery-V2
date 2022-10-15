package com.nas.consumerservice.service;

import com.nas.common.Money;
import com.nas.consumerservice.command.ConsumerCommand;
import com.nas.consumerservice.model.Consumer;
import io.eventuate.tram.events.publisher.ResultWithEvents;

public interface ConsumerService {
    ResultWithEvents<Consumer> create(final ConsumerCommand command);
    Consumer findById(String id);
    void validateOrderForConsumer(String consumerId, Money orderTotal);
}
