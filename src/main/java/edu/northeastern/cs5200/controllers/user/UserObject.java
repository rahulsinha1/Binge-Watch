package edu.northeastern.cs5200.controllers.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="user")
public class UserObject {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private int id;

	private String username;
	
	private String pass;
	
	
	public UserObject()
	{
		
	}
	
	public UserObject(int id,String userName,String password) {
		this.id = id;
		this.username = userName;
		this.pass = password;
	}
	
	public UserObject(String userName,String password) {
		this.username = userName;
		this.pass = password;
	}

	
	public int getId(int id) {
		return id;
	}


	public void seId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return username;
	}


	public void setUserName(String userName) {
		this.username = userName;
	}

	
	

	public String getPassword() {
		return pass;
	}


	public void setPassword(String password) {
		this.pass = password;
	}
}


