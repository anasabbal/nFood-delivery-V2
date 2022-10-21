package com.nas.accountservice.service;

import com.nas.accountservice.model.Account;
import com.nas.accountservice.model.AccountCommand;
import com.nas.accountservice.repository.AccountRepository;
import io.eventuate.tram.events.publisher.DomainEventPublisher;
import io.eventuate.tram.events.publisher.ResultWithEvents;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{


    private final AccountRepository accountRepository;
    private final DomainEventPublisher domainEventPublisher;


    @Override
    public ResultWithEvents<Account>  create(AccountCommand accountCommand) {
        final ResultWithEvents<Account> accountResultWithEvents = Account.create(accountCommand);
        accountRepository.save(accountResultWithEvents.result);

        domainEventPublisher.publish(
                Account.class,
                accountResultWithEvents.result.getId(),
                accountResultWithEvents.events
        );
        return accountResultWithEvents;
    }
}
