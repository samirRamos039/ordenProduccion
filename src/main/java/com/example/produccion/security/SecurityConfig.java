package com.example.produccion.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Aitowired
	private UserDS userDS;
	@Bean 	
	public SecurityFilterChain SecurityFilterChain(HttpSecurity HttpSecurity)
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
				 .httpBasic(Cuatomizer.whitDefaults())
				 
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
