package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController 
{
	
	@Autowired
	private JwtUtil jwtutil;
	
	@Autowired
	private CustomUserDetailsService customuserdetailsservice;
	
	
	@PostMapping("/token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtrequest) throws Exception
	{
		System.out.println("inside token method");
		System.out.println(jwtrequest);
		UserDetails userdetails=this.customuserdetailsservice.loadUserByUsername(jwtrequest.getUsername());
		String token=this.jwtutil.generateToken(userdetails);
		System.out.println("JWT "+token);
		return ResponseEntity.ok(new JwtResponse(token));
	}
}
