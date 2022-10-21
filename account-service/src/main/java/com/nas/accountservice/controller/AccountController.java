package com.nas.accountservice.controller;


import com.nas.accountservice.dto.AccountDTO;
import com.nas.accountservice.dto.mapper.AccountMapper;
import com.nas.accountservice.model.Account;
import com.nas.accountservice.model.AccountCommand;
import com.nas.accountservice.service.AccountService;
import io.eventuate.tram.events.publisher.ResultWithEvents;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static com.nas.core.ResourcePaths.V2;
import static com.nas.core.ResourcePaths.ACCOUNT;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping(V2 + ACCOUNT)
public class AccountController {

    private final AccountService accountService;
    private final AccountMapper accountMapper;


    @RequestMapping(method = RequestMethod.POST )
    public ResponseEntity<AccountDTO> create(@RequestBody final AccountCommand accountCommand){
        final ResultWithEvents<Account> accountResultWithEvents = accountService.create(accountCommand);
        final URI uri = fromCurrentRequest().path("/{id}").buildAndExpand(accountResultWithEvents.result.getId()).toUri();
        return ResponseEntity.created(uri).body(accountMapper.toDTO(accountResultWithEvents.result));
    }
}
