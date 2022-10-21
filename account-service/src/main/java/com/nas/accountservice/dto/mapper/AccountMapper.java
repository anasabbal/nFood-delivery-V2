package com.nas.accountservice.dto.mapper;


import com.nas.accountservice.dto.AccountDTO;
import com.nas.accountservice.model.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class AccountMapper {

    public abstract AccountDTO toDTO(Account account);
}
