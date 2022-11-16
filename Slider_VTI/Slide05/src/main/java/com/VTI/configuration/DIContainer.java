package com.VTI.configuration;

import com.VTI.utils.HibernateUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DIContainer {
    @Bean
    public HibernateUtils provideHibernateUtils(){
        return new HibernateUtils();
    }
}
