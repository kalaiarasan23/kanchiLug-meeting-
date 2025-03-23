package connectJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectJDBC.entity.User;

//import java.sql.*;

public class MainClass {
	String url ;
	String userName ;
	String password ;
	Connection conn;
	MainClass() throws SQLException{
		url = "jdbc:postgresql://localhost:5432/demo_DB";
		userName = "newuser";
		password = "1234";
		conn = DriverManager.getConnection(url, userName, password);
		   tableCreation();
	}


	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		MainClass main = new MainClass();
//		main.updateTable();
		User u = new User(1,"ram",21);
	    main.addUser(u);
	    List<User> li =main.printUser();
	    for(User user : li) {
	    	System.out.println(user);
	    }
//	    main.dropTable();
//	     li =main.printUser();
//	    for(User user : li) {
//	    	System.out.println(user);
//	    }
	}

	public void tableCreation() throws SQLException {

		String sql = "CREATE TABLE IF NOT EXISTS users(" +
				"id SERIAL PRIMARY KEY, " +
				"name VARCHAR(100) NOT NULL, " +
				"age INT" +
				");";
		Statement statement = conn.createStatement();
		statement.executeUpdate(sql);
		System.out.println("table created");
	}
	
	public void updateTable() throws SQLException {
        String sql = "ALTER TABLE users ADD COLUMN email VARCHAR(100)";
        Statement statement = conn.createStatement();
        statement.executeUpdate(sql);
        System.out.println("Table update column email successfully");
	}
	
	public void dropTable() throws SQLException {
		String sql = "DROP TABLE users";
		Statement statement = conn.createStatement();
		statement.executeUpdate(sql);
		System.out.println("Table drop");
	}
	
	private void addUser(User user) throws SQLException {
        String sql = "INSERT INTO users (name, age) VALUES (?, ?)";

             PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.executeUpdate();
            System.out.println("User added: " + user.getName());
        
    }
	
	public List<User> printUser() throws SQLException {
		List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM users";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
        	userList.add(new User(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getInt("age")));
        }
        return userList;
	}
		
}
