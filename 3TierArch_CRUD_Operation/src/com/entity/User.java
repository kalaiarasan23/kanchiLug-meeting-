package com.entity;

//entity
public class User {
	private static int generate_Id =1;
	private int id, age;
	private String name, phoneNumber, UserName, password;

	
	public User(int age, String phoneNumber, String name, String userName, String password) {
		this.id = generate_Id++;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.name = name;
		UserName = userName;
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", phoneNumber=" + phoneNumber + ", UserName="
				+ UserName + ", password=" + password + "]";
	}

	
	
}
