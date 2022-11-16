package com.YangKang.configuration;

import com.YangKang.configuration.exception.RestExceptionHandler;
import com.YangKang.configuration.security.JWTAuthenticationFilter;
import com.YangKang.service.IAccountService;
import com.YangKang.validation.AccountExistsById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfigurationSource;

import static org.springframework.security.config.Customizer.withDefaults;


@EnableWebSecurity
public class WebsecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    IAccountService accountService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RestExceptionHandler exceptionHandler;


    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        // Get AuthenticationManager bean
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(accountService) // Cung cáp userservice cho spring security
                .passwordEncoder(passwordEncoder); // cung cấp password encoder
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .csrf().disable()
//                .cors(withDefaults())
//                .exceptionHandling(
//                        handler ->handler.authenticationEntryPoint(exceptionHandler)
//                                .accessDeniedHandler(exceptionHandler)
//                )
//                .authorizeHttpRequests(handler ->
//                        handler
//                                .antMatchers("/api/v1/accounts/**")
//                                .hasAnyAuthority("ADMIN")
//                                .antMatchers(HttpMethod.DELETE) // muốn delete
//                                .hasAnyAuthority("ADMIN") // phải là quyền admin
//                                .antMatchers(HttpMethod.POST,"/api/v1/products","/api/v1/accounts","/api/v1/categories")
//                                .hasAnyAuthority("ADMIN","MANAGER")
//                                .antMatchers(HttpMethod.PUT,"/api/v1/products","/api/v1/accounts","/api/v1/categories")
//                                .hasAnyAuthority("ADMIN","MANAGER")
//                                .antMatchers(HttpMethod.GET,"/api/v1/product")
//                                .permitAll()
//                                .antMatchers("/api/v1/auth/**")
//                                .permitAll()
//                                .anyRequest().authenticated()
//                )
//                .httpBasic(withDefaults())
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                .cors() // Ngăn chặn request từ một domain khác
                .and()
                .authorizeRequests()
                .antMatchers("api/v1/accounts/**")
                .hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE)
                .hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.POST,"/api/v1/products","/api/v1/accounts","/api/v1/categories")
                .hasAnyAuthority("ADMIN","MANAGER")
                .antMatchers(HttpMethod.PUT,"/api/v1/products","/api/v1/accounts","/api/v1/categories")
                .hasAnyAuthority("ADMIN","MANAGER")
                .antMatchers(HttpMethod.GET,"/api/v1/products")
                .permitAll()
                .antMatchers("/api/v1/auth/*" ).permitAll() // Cho phép tất cả mọi người truy cập vào địa chỉ này
                .anyRequest().authenticated(); // Tất cả các request khác đều cần phải xác thực mới được truy cập

        // Thêm một lớp Filter kiểm tra jwt
        http.addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
//
//    public CorsConfigurationSource corsConfigurationSource(){
//    final
//    }

}

