package com.example.services;

import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.example.entities.User;


public class MyUserPrincipal implements UserDetails 
{
	
	private static final long serialVersionUID = 1L;
	private User user;

    public MyUserPrincipal(User user) {
        this.user = user;
    }
  
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		System.out.println("inside getAuthorities method");
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		System.out.println("password is\t"+user.getPassword());
		return passwordEncoder().encode(user.getPassword());
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		System.out.println("username is\t"+user.getUsername());
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}

