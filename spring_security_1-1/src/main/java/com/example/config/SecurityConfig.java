package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig 
{
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	// for user configuration
	
	@Bean
	public UserDetailsService userDetailsService()
	{
		UserDetails normalUser=User
								.withUsername("scott")
								.password(passwordEncoder().encode("tiger"))
								.roles("NORMAL")
								.build();

		
		  UserDetails publicUser=User .withUsername("vita1")
		  .password(passwordEncoder().encode("vita1")) .roles("PUBLIC") .build();
		 
		UserDetails adminUser=User
				.withUsername("master")
				.password(passwordEncoder().encode("blaster"))
				.roles("ADMIN")
				.build();
		// InMemoryUserDetailsManager is a implementation of 
		// UserDetailsService
		InMemoryUserDetailsManager imd=new InMemoryUserDetailsManager(normalUser,publicUser,adminUser);
		return imd;
	}
	// Using HttpSecurity we can configure which api can 
	// be accessed by whom, whether we want 'form-based' or 
	// 'basic' authentication
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity hs) throws Exception
	{
		
			hs.csrf().disable()
				.authorizeHttpRequests((authorize)->authorize
						.anyRequest()
						.authenticated())
						.httpBasic(Customizer.withDefaults());
					         		
			return hs.build();
			
	}
	
}

