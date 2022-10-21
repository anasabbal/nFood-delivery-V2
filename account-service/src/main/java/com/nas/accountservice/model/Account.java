package com.nas.accountservice.model;


import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

import com.nas.consumerservice.model.Consumer;
import com.nas.core.BaseEntity;
import io.eventuate.tram.events.publisher.ResultWithEvents;

public class Account extends BaseEntity {


    @OneToOne
    private Consumer customer;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private AccountStatus status;

    public static Account createAccount(final AccountCommand command){
        final Account account = new Account();

        account.customer = new Consumer();
        account.status = AccountStatus.NEW;

        return account;
    }

    public static ResultWithEvents<Account> create(final AccountCommand command){
        return new ResultWithEvents<>(new Account(), new AccountCreated());
    }
}
