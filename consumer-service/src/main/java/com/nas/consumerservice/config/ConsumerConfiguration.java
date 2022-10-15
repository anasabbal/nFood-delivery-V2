package com.nas.consumerservice.config;


import com.nas.common.CommonConfiguration;

import com.nas.consumerservice.command.ConsumerServiceCommandHandlers;
import io.eventuate.tram.commands.consumer.CommandDispatcher;
import io.eventuate.tram.sagas.participant.SagaCommandDispatcherFactory;
import io.eventuate.tram.spring.jdbckafka.TramJdbcKafkaConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import io.eventuate.tram.spring.events.publisher.TramEventsPublisherConfiguration;
import io.eventuate.tram.sagas.spring.participant.SagaParticipantConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@Import(
        {SagaParticipantConfiguration.class,
                TramEventsPublisherConfiguration.class,
                CommonConfiguration.class,
                SagaParticipantConfiguration.class, TramJdbcKafkaConfiguration.class}
)
@ComponentScan
@EnableAutoConfiguration
public class ConsumerConfiguration {

    @Bean
    public ConsumerServiceCommandHandlers consumerServiceCommandHandlers() {
        return new ConsumerServiceCommandHandlers();
    }
    @Bean
    public CommandDispatcher commandDispatcher(ConsumerServiceCommandHandlers consumerServiceCommandHandlers,
                                               SagaCommandDispatcherFactory sagaCommandDispatcherFactory) {
        return sagaCommandDispatcherFactory.make("consumerServiceDispatcher", consumerServiceCommandHandlers.commandHandlers());
    }
}
