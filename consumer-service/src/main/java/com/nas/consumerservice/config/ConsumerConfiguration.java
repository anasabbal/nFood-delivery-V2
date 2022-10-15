package com.nas.consumerservice.config;


import com.nas.common.CommonConfiguration;
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
                SagaParticipantConfiguration.class}
)
public class ConsumerConfiguration {
}
