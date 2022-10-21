package com.nas.accountservice.service;

import com.nas.accountservice.model.Account;
import com.nas.accountservice.model.AccountCommand;
import io.eventuate.tram.events.publisher.ResultWithEvents;

public interface AccountService {
    ResultWithEvents<Account> create(AccountCommand accountCommand);
}
