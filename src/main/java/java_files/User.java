package java_files;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")

public class User 
{
	public User(String number, String name, String status, String dob, String username, String password) {
		super();
		this.number = number;
		this.name = name;
		this.status = status;
		this.dob = dob;
		this.username = username;
		this.password = password;
	}

	@Id	
	@Column(name="number")
	public String number;
	
	@Column(name="name")
	public String name;
	
	@Column(name="status")
	public String status;
	
	@Column(name="dob")
	public String dob;
	
	@Column(name="username")
	public String username;
	
	@Column(name="password")
	public String password;

	public User() 
	{
		
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

	@Override
	public String toString() {
		return "User [name=" + name + ", status=" + status + ", dob=" + dob + ", number=" + number + ", username="
				+ username + ", password=" + password + "]";
	}
	
	
	
	
}
