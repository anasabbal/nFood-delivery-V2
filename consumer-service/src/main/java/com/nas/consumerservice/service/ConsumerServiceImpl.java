package com.nas.consumerservice.service;


import com.nas.common.PersonName;
import com.nas.consumerservice.command.ConsumerCommand;
import com.nas.consumerservice.exception.ConsumerNotFoundException;
import com.nas.consumerservice.model.Consumer;
import com.nas.consumerservice.repository.ConsumerRepository;
import io.eventuate.tram.events.publisher.DomainEventPublisher;
import io.eventuate.tram.events.publisher.ResultWithEvents;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ConsumerServiceImpl implements ConsumerService{

    private final ConsumerRepository consumerRepository;
    private final DomainEventPublisher domainEventPublisher;


    @Override
    @Transactional
    public ResultWithEvents<Consumer> create(final ConsumerCommand command){
        final ResultWithEvents<Consumer> consumerResultWithEvents = Consumer.create(command);
        consumerRepository.save(consumerResultWithEvents.result);
        domainEventPublisher.publish(
                Consumer.class,
                consumerResultWithEvents.result.getId(),
                consumerResultWithEvents.events
        );
        return consumerResultWithEvents;
    }


    @Override
    public Consumer findById(String id){
        return consumerRepository.findById(id).orElseThrow(
                () -> new ConsumerNotFoundException("Consumer Not Found"));
    }
}
