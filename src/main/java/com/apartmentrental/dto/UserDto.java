package com.apartmentrental.dto;

import java.io.Serializable;


import javax.validation.constraints.Size;

public class UserDto implements Serializable 
{
	private static final long serialVersionUID = 4865903039190150223L;
	

	public String number;
	

	public String name;
	

	public String status;
	

	public String dob;
	
	@Size(min=1,message="is required")
	public String username;
	
	@Size(min=1,message="is required")
	public String password;
	

	public UserDto() 
	{
		//intentionally kept empty
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
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
