package com.YangKang.configuration;

import com.YangKang.configuration.security.JWTAuthenticationFilter;
import com.YangKang.entity.Account;

import com.YangKang.form.AccountCreateForm;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DIContainer {
    @Bean
    public ModelMapper provideMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(AccountCreateForm.class, Account.class)
                .addMappings(mapper -> mapper.skip(Account :: setId));
        return modelMapper;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JWTAuthenticationFilter jwtAuthenticationFilter() {
        return new JWTAuthenticationFilter();
    }
}
