package com.apartmentrental.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="admin")
public class Admin implements Serializable
{
	private static final long serialVersionUID = 4865903039190150223L;
	@Id
	@Size(min=1,message="is required")
	@Column
	public String username;
	
	@Column
	@Size(min=1,message="is required")
	public String password;
	
	public Admin()
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

	@Override
	public String toString() {
		return "Admin [username=" + username + ", password=" + password + "]";
	}
	
	
}
