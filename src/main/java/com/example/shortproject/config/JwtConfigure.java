package com.example.shortproject.config;

import com.example.shortproject.jwt.JwtFilter;
import com.example.shortproject.jwt.TokenProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class JwtConfigure {


    @Value("${jwt.secret.key}")
    private String accessTokenSecret;

    private final Long accessTokenValidityTime = 60 * 60 * 1000L;

    @Bean
    public TokenProvider tokenProvider() {
        return new TokenProvider(accessTokenSecret, accessTokenValidityTime);
    }

}
