package com.vti.configuration;

import com.vti.entity.Account;
import com.vti.form.AccountCreateForm;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DIContainer {
    @Bean
    public ModelMapper provideModelMapper(){
       ModelMapper modelMapper = new ModelMapper();
       modelMapper.typeMap(AccountCreateForm.class, Account.class)
               .addMappings(mapper ->mapper.skip(Account::setId));
        return modelMapper;

    }
}
