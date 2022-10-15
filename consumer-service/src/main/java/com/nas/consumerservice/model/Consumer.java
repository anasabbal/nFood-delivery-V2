package com.nas.consumerservice.model;


import com.nas.common.PersonName;
import com.nas.consumerservice.command.ConsumerCommand;
import com.nas.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import io.eventuate.tram.events.publisher.ResultWithEvents;

import javax.persistence.*;

@Entity
@Table
@Access(AccessType.FIELD)
@Getter
@Setter
public class Consumer extends BaseEntity {


    @Embedded
    private PersonName personName;

    public Consumer(){

    }

    public Consumer(PersonName personName) {
        this.personName = personName;
    }

    public static ResultWithEvents<Consumer> create(final ConsumerCommand command){
        return new ResultWithEvents<>(new Consumer(command.getPersonName()), new ConsumerCreated());
    }
}
