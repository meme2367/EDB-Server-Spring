package com.example.rest.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.rest.config.jwt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

import static com.auth0.jwt.JWT.require;

/**
 * application.properties : jwt information
 * @author MyeongDayeon
 *
 */

@Slf4j
@Service
public class jwtService {

    private String ISSUER = jwt.ISSUER;

    private String SECRET = jwt.SECRET;


    public String create(final int idx,final String grade) {

        try {
            //토큰 생성 빌더 객체 생성
            JWTCreator.Builder b = JWT.create();
            //토큰 생성자 명시
            b.withIssuer(ISSUER);

            //토큰 payload 작성, key - value 형식, 객체도 가능
            b.withClaim("user_idx", idx);
            b.withClaim("grade",grade);
            //만료날짜지정, 1달로
            b.withExpiresAt(expireAt());
            //토큰 해싱해서 반환


            return b.sign(Algorithm.HMAC256(SECRET));//token
        } catch (JWTCreationException JwtCreationException) {
            log.info(JwtCreationException.getMessage());
        }
        return null;
    }


    private Date expireAt(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        //한달은 24*31
        cal.add(Calendar.MONTH, 1);
        return  cal.getTime();
    }

    public Token decode(final String token) {
////service prover의 외부서비스 등록 등 인가
        try {
            //토큰 해독 객체 생성
            final JWTVerifier jwtVerifier = require(Algorithm.HMAC256(SECRET)).withIssuer(ISSUER).build();
            //토큰 검증
            DecodedJWT decodedJWT = jwtVerifier.verify(token);

            //토큰 payload 반환, 정상적인 토큰이라면 토큰 주인(사용자) 고유 ID, 아니라면 -1
            return new Token(decodedJWT.getClaim("user_idx").asLong().intValue(),
                    decodedJWT.getClaim("grade").asLong().toString());

        } catch (JWTVerificationException jve) {
            log.error(jve.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return new Token();
    }

    public static class Token {
        //토큰에 담길 정보 필드
        //초기값을 -1로 설정함으로써 로그인 실패시 -1반환
        private int user_idx = -1;
        private String grade = "USER";

        public Token() {
        }

        public Token(final int user_idx, final String grade) {
            this.user_idx = user_idx; this.grade = grade;
        }

        public int getUser_idx() {
            return user_idx;
        }
        public String getGrade() {
            return grade;
        }

    }

    //반환될 토큰Response
    public static class TokenResponse {
        //실제 토큰
        private String token;

        public TokenResponse() {
        }

        public TokenResponse(final String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

    }
}