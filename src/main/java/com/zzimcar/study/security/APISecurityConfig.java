package com.zzimcar.study.security;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Order(1)
public class APISecurityConfig {

  @Value("${zzimcar.http.auth-token-header.name}")
  private String principalRequestHeader;

  @Value("${zzimcar.http.auth-token}")
  private String principalRequestValue;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    APIKeyAuthFilter filter = new APIKeyAuthFilter(principalRequestHeader);
    filter.setAuthenticationManager(authentication -> {
      String principal = (String) authentication.getPrincipal();
      if (!Objects.equals(principalRequestValue, principal)) {
        throw new BadCredentialsException("hello");
      }
      authentication.setAuthenticated(true);
      return authentication;
    });

    http.cors().disable()
        .csrf().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .addFilter(filter)
        .authorizeRequests().anyRequest().authenticated().and().formLogin().disable();
    return http.build();
  }
}
