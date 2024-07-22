package com.example.produccion.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
	private UserDS userDS;
	@Bean 	
	public SecurityFilterChain SecurityFilterChain(HttpSecurity HttpSecurity)
			throws Exception {
				return HttpSecurity
				 .csrf(config -> config.disable())
				 .authorizeHttpRequests(auth -> {
					auth.requestMatchers(HttpMethod.GET,"/usuario","/producto").permitAll();
					auth.requestMatchers("/inventario").hasRole("ADMIN");
					auth.anyRequest().authenticated();
				 })
				 .sessionManagement(session -> {
					session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
				 })
				 .httpBasic(Customizer.withDefaults())
				 
				 .build();
	}

	@Bean
	UserDetailsService UserDetailsService(){
		return userDS;	
	}
    
	@Bean
	PasswordEncoder PasswordEncoder(){
        return new BCryptPasswordEncoder();
	}

    @Bean
	AuthenticationManager AuthenticationManager(HttpSecurity httpSecurity, PasswordEncoder paswordEncoder)throws Exception{
		return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
		         .userDetailsService(UserDetailsService())
				 .passwordEncoder(paswordEncoder)
				 .and()
				 .build();
	}
}
