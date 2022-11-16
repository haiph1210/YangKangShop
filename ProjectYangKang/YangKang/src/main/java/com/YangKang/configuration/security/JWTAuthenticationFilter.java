package com.YangKang.configuration.security;

import com.YangKang.service.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class JWTAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JWTTokenProvider tokenProvider;
    @Autowired
    private IAccountService customUserDetailsService;


    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        try {
//            // lấy jwt từ request
//             String jwt = getJwtFromRequest(request);
//             if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)){
////                 lấy id user từ jwt
//                 Integer accountId= tokenProvider.getAccountIdFromJWT(jwt);
//                 IAccountService accountService = customUserDetailsService.loadUserById(accountId);
//                if (accountService != null){
//                    // người dùng hojpw lệ xét thông tin cho security context
//                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(accountService,null,accountService.getAuthorities());
//                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                    SecurityContextHolder.getContext().setAuthentication(authentication);
//                }
//
//             }
//        }
//    }
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            // Lấy jwt từ request
            String jwt = getJwtFromRequest(request);

            if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
                // Lấy id user từ chuỗi jwt
                Integer userId = tokenProvider.getAccountIdFromJWT(jwt);
                // Lấy thông tin người dùng từ id
                 UserDetails userDetails = customUserDetailsService.loadUserById(userId);
                if(userDetails != null) {
                    // Nếu người dùng hợp lệ, set thông tin cho Seturity Context
                    UsernamePasswordAuthenticationToken
                            authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        } catch (Exception ex) {
            log.error("failed on set user authentication", ex);
        }

        filterChain.doFilter(request, response);
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        // ktra xem header Author có chứa thông tin jwt ko
        if (StringUtils.hasText(bearerToken)&& bearerToken.startsWith("Bearer   ")){
            return bearerToken.substring(7);
        }
        return null;
    }
}
