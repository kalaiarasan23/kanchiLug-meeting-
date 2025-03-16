package com.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.entity.User;

// Repo layer
public class UserRepository {
	Map<Integer, User> map ;
	
	public UserRepository() {
		map = new HashMap<>();
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
