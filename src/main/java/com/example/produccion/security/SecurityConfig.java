package com.example.produccion.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

	@Bean 	
	public SecurityFilterChain authorizationServerSecurityFilterChain(HttpSecurity HttpSecurity)
			throws Exception {
				return HttpSecurity
				 .csrf(config -> config.disable())
				 .authorizeHttpRequests(auth -> {
					auth.requestMatchers("/usuario").permitAll();
					auth.anyRequest().authenticated();
				 })
				 .sessionManagement(session -> {
					session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
				 })
				 .httpBasic(null)
				 
				 .build();
	}


}
