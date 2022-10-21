package com.nas.accountservice.config;

import io.eventuate.tram.commands.consumer.CommandDispatcher;
import io.eventuate.tram.sagas.participant.SagaCommandDispatcherFactory;
import io.eventuate.tram.sagas.spring.participant.SagaParticipantConfiguration;
import io.eventuate.tram.spring.events.publisher.TramEventsPublisherConfiguration;
import io.eventuate.tram.spring.jdbckafka.TramJdbcKafkaConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@Import(
        {SagaParticipantConfiguration.class,
                TramEventsPublisherConfiguration.class,
                SagaParticipantConfiguration.class, TramJdbcKafkaConfiguration.class}
)
@ComponentScan
@EnableAutoConfiguration
public class AccountConfig {

    @Bean
    public CommandDispatcher commandDispatcher(SagaCommandDispatcherFactory sagaCommandDispatcherFactory) {
        return sagaCommandDispatcherFactory.make("consumerServiceDispatcher", null);
    }
}
