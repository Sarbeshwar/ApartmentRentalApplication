package com.apartmentrental.dto;

import java.io.Serializable;

import javax.validation.constraints.Size;

public class AdminDto implements Serializable
{
	private static final long serialVersionUID = 4865903039190150223L;

	@Size(min=1,message="is required")
	public String username;
	
	@Size(min=1,message="is required")
	public String password;
	
	public AdminDto()
	{
		//intentionally kept empty
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
