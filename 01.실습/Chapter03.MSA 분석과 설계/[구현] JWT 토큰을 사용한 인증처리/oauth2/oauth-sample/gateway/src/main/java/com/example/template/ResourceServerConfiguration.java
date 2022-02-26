package com.example.template;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class ResourceServerConfiguration {

    @Bean
    SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) throws Exception {

        http
                .cors().and()
                .csrf().disable()
                .authorizeExchange()
                .pathMatchers("/products/**","/goods/**","/oauth/**","/login/**").permitAll()   //이 주소에 대해서는 인증 필요 없음
                .anyExchange().authenticated()
                .and()
                .oauth2ResourceServer() //나머지에 대해서는 인증을 요구하는 설정
                .jwt()
                ;

        return http.build();
    }

}
