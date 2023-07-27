package com.example.demo;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService
{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("inside loaduserbyname method");
		if(username.equals("scott"))
		{
			return new User("scott",new BCryptPasswordEncoder().encode("tiger"),new ArrayList<>());
		}
		else
		{
			throw new UsernameNotFoundException("User not found");
		}
	}

}
