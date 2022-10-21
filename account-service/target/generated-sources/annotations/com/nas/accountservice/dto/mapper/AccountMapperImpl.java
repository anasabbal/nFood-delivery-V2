package com.nas.accountservice.dto.mapper;

import com.nas.accountservice.dto.AccountDTO;
import com.nas.accountservice.model.Account;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-21T16:41:29+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.4.1 (Oracle Corporation)"
)
@Component
public class AccountMapperImpl extends AccountMapper {

    @Override
    public AccountDTO toDTO(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountDTO accountDTO = new AccountDTO();

        accountDTO.setId( account.getId() );

        return accountDTO;
    }
}
