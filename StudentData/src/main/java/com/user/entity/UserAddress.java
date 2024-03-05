package com.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Address")
public class UserAddress {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
private	int  userId;
 private String city;
 private String  state;
 private String pincode;
 @OneToOne

  private User user;
public UserAddress() {
	super();
	// TODO Auto-generated constructor stub
}
public UserAddress(int userId, String city, String state, String pincode, User user) {
	super();
	this.userId = userId;
	this.city = city;
	this.state = state;
	this.pincode = pincode;
	this.user = user;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getPincode() {
	return pincode;
}
public void setPincode(String pincode) {
	this.pincode = pincode;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}


}
