package com.vti.slide08.configuration.security;

import com.vti.slide08.configuration.exception.RestExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;

import static org.springframework.security.config.Customizer.withDefaults;

@Component
@EnableWebSecurity

public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RestExceptionHandler exceptionHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    http
            .csrf().disable() // chặn gọi đến từ bên ứng dụng thuws ba
            .cors(withDefaults())
            .exceptionHandling(handler -> handler
                    .authenticationEntryPoint(exceptionHandler)
                    .accessDeniedHandler(exceptionHandler)
            )
            .authorizeHttpRequests(handler -> handler
                    .antMatchers(HttpMethod.DELETE)// muốn delete quyền admin
                    .hasAuthority("ADMIN")
                    .antMatchers(HttpMethod.POST, "/api/v1/departments", "/api/v1/accounts")  //
//                    .hasAnyAuthority("ADMIN", "MANAGER")
                            .permitAll()
                    .antMatchers(HttpMethod.PUT, "/api/v1/departments", "/api/v1/accounts")
                    .hasAnyAuthority("ADMIN", "MANAGER")
                    .antMatchers("/api/v1/auth/**")
                    .permitAll()
                    .anyRequest().authenticated()

            )
            .httpBasic(withDefaults())
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // ko lưu truwx gì
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE"));
        configuration.applyPermitDefaultValues();

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
