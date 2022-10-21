package com.nas.consumerservice.command;


import lombok.Getter;

public class ConsumerCommand {
    private Object personName;

    public Object getPersonName() {
        return personName;
    }

    public void setPersonName(Object personName) {
        this.personName = personName;
    }
}
