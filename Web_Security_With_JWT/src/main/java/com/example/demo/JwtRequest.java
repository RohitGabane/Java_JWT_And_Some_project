package com.example.demo;

public class JwtRequest 
{
	private String username,password;

	@Override
	public String toString() {
		return "JwtRequest [username=" + username + ", password=" + password + "]";
	}

	public JwtRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		System.out.println("JwtRequest parameterized constructor");
	}

	public JwtRequest() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("JwtRequest default constructor");
	}

	public void setUsername(String username) {
		this.username = username;
		System.out.println("JwtRequest set username method");
	}

	public void setPassword(String password) {
		this.password = password;
		System.out.println("JwtRequest set password method");
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
}
