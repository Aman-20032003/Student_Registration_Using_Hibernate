package com.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User{ 
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int userId;
private String password;
@OneToOne
private UserAddress address;
@OneToOne
private UserDetails details;
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(int userId, String password, UserAddress address, UserDetails details) {
	super();
	this.userId = userId;
	this.password = password;
	this.address = address;
	this.details = details;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public UserAddress getAddress() {
	return address;
}
public void setAddress(UserAddress address) {
	this.address = address;
}
public UserDetails getDetails() {
	return details;
}
public void setDetails(UserDetails details) {
	this.details = details;
}

}