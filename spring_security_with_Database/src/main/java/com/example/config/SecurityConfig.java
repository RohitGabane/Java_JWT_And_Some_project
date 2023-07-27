package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.services.MyUserDetailsService;

@Configuration
public class SecurityConfig 
{
	 @Autowired 
	 private MyUserDetailsService userDetailsService;
	
     @Bean
     public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity hs) throws Exception
	{
		System.out.println("inside filterchain method");
		hs.csrf().disable()
		.authorizeHttpRequests((authorize)->authorize
				.anyRequest()
				.authenticated())
				.httpBasic(Customizer.withDefaults());
			         		
		return hs.build();         		
	
	}
}
