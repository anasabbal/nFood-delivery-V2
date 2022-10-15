package com.nas.consumerservice.command;


import com.nas.common.PersonName;
import lombok.Getter;

public class ConsumerCommand {
    private PersonName personName;

    public PersonName getPersonName() {
        return personName;
    }

    public void setPersonName(PersonName personName) {
        this.personName = personName;
    }
}
