package main.repository;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.entity.User;

// Repo layer
public class UserRepository {
	Map<Integer, User> map ;
	
	String url ;
	String userName ;
	String password ;
	Connection conn;
	
	public UserRepository() throws SQLException {
		map = new HashMap<>();
		url = "jdbc:postgresql://localhost:5432/demo_DB";
		userName = "newuser";
		password = "1234";
		conn = DriverManager.getConnection(url, userName, password);
		   tableCreation();

	}
	
	public void tableCreation() throws SQLException {

		String sql = "CREATE TABLE IF NOT EXISTS student(" +
				"id SERIAL PRIMARY KEY, " +
				"name VARCHAR(100) NOT NULL, " +
				"age INT," +
				"phoneNumber BIGINT,"+
				"userName VARCHAR(50),"+
				"password VARCHAR(50)"+
				");";
		Statement statement = conn.createStatement();
		statement.executeUpdate(sql);
		System.out.println("table created");
	}
	
	public void createUser(User u) {
		map.put(u.getId(),u);
	}
	
	public User getUser(int id) {
		return map.get(id);
	}
	
	
	public void delete(int id) {
		map.remove(id);
	}
	
	public boolean containId(int id) {
		return map.containsKey(id);
	}
	
	public List<User> display(){
		
		
		return new ArrayList<User>(map.values());
	}
	
}
