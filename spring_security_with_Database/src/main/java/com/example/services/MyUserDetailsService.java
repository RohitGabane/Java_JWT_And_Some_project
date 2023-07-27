package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.UserRepository;
import com.example.entities.User;

@Service
public class MyUserDetailsService implements UserDetailsService 
{
	@Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
    	System.out.println("inside loaduserbyusername\t"+username);
        User user = userRepository.findByUsername(username);
        System.out.println("user from database is\t"+user);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(user);
    }
}
