package com.YangKang.configuration.security;

import com.YangKang.service.CustomAccountDetail;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JWTTokenProvider {
    // bis mật chỉ có server biết
    private final String JWT_SECRET = "lodaaaaaa";
//     thời gian của chuỗi jwt
    private final long JWT_EXPIRATION = 604800000L;
//     tapo ra jwt  từ user
    public String gennerateToken(CustomAccountDetail accountDetail){
        Date date = new Date();
        Date expiryDate = new Date(date.getTime()+ JWT_EXPIRATION);
//        tạo chuỗi json từ token
        return Jwts.builder()
                .setSubject(Integer.toString(accountDetail.getAccount().getId()))
                .setIssuedAt(date)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512,JWT_SECRET)
                .compact();
    }

//    lấy thông tin từ JWT
    public Integer getAccountIdFromJWT(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
        return Integer.parseInt(claims.getSubject());
    }

    public boolean validateToken(String authToken){
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        }catch (MalformedJwtException ex){
            log.error("Invalid JWT Token");
        }catch (ExpiredJwtException ex){
            log.error("Expired JWT Token");
        }catch (UnsupportedJwtException ex){
            log.error("Unsupport JWT Token");
        }catch (IllegalArgumentException ex){
            log.error("JWT Claims String Is Empty");
        }
        return false;
    }
}
