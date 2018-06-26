package com.ally.invoicify.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userLogins")
public class UserLogin {
	
	@Id
    @GeneratedValue
	private Integer id;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserLogin() {
		
	}
	
	public UserLogin(String username, String password) {
		this.userName = username;
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
