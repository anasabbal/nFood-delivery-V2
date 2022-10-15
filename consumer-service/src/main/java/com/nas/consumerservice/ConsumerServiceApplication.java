package com.nas.consumerservice;


import com.nas.consumerservice.config.ConsumerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import io.eventuate.tram.spring.jdbckafka.TramJdbcKafkaConfiguration;

@SpringBootApplication
@Import({ConsumerConfiguration.class, TramJdbcKafkaConfiguration.class})
public class ConsumerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerServiceApplication.class, args);
    }
}
