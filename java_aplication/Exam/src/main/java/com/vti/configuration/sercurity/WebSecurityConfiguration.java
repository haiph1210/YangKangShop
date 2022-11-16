package com.vti.configuration.sercurity;

import com.vti.configuration.exception.RestExceptionHandler;
import com.vti.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
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


    //đăng nhập ko phân quyền
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
//    }
//
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//       http
//               .csrf().disable()
//               .cors(withDefaults())
//               .authorizeHttpRequests(handler ->
//                       handler
//                               .anyRequest()
//                               .permitAll()
//               ) // phân quyền cho tất cả
//               .httpBasic(withDefaults())
//               .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//    }

// đăng nhaajp có phân quyền
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
               .csrf().disable()
               .cors(withDefaults())
               .exceptionHandling(
                       handler ->handler.authenticationEntryPoint(exceptionHandler)
                               .accessDeniedHandler(exceptionHandler)
               )
               .authorizeHttpRequests(handler ->
                       handler
                               .antMatchers("/api/v1/accounts/**")
                               .hasAnyAuthority("ADMIN")
                               .antMatchers(HttpMethod.DELETE) // muốn delete
                               .hasAnyAuthority("ADMIN") // phải là quyền admin
                               .antMatchers(HttpMethod.POST,"/api/v1/departments","/api/v1/accounts")
                               .hasAnyAuthority("ADMIN","MANAGER")
                               .antMatchers(HttpMethod.PUT,"/api/v1/departments","/api/v1/accounts")
                               .hasAnyAuthority("ADMIN","MANAGER")
                               .antMatchers(HttpMethod.GET,"/api/v1/departments")
                               .permitAll()
                               .antMatchers("/api/v1/auth/**")
                               .permitAll()
                               .anyRequest().authenticated()
               )
               .httpBasic(withDefaults())
               .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
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

//    @Bean
//    public AuthenticationManager authManager(HttpSecurity http, UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) throws Exception {
//        return http.getSharedObject(AuthenticationManagerBuilder.class)
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder)
//                .and()
//                .build();
//    }
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().antMatchers(
//                HttpMethod.GET,
//                "/swagger*/**",
//                "/webjars/**",
//                "/v2/api-docs"
//        );
//    }
}
