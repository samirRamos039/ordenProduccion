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
				 .and()
				 .build();
	}

	@Bean
	UserDetailServer UserDetailServer(){
		InMemoryDetailsManager manager = InMemoryDetailsManager();
		manager.createUser(User.withUsername("samir")
		    .password("1234")
			.role()
			.build());

		return manager;	
	}
    @Bean
	PaswordEncoder paswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
	}

    @Bean
	AuthenticationManager autenticationManager(HttpSecurity httpSecurity, PaswordEncoder paswordEncoder)throws Exception{
		retrurn httpSecurity.getSharedObject(AuthenticationMangerBuilder.class)
		         .userDetailsService(userDetailsService())
				 .paswordEncoder(paswordEncoder)
				 .and()
				 .build()
	}
}
