package main.Service;

import java.util.List;

import main.entity.User;
import main.repository.UserRepository;

public class UserService {
	UserRepository userRepository;
	
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
		userRepository.createUser(new User(21, "5555555555", "ganesh", "ganesh_1234", "12345"));
		userRepository.createUser(new User(22, "1234214223", "hari", "hari_23", "09876"));
	}
	
	
	public void addUser(User u) {
		userRepository.createUser(u);
	}
	
	public User getUser(int id) {
		if(userRepository.containId(id)) {
			return userRepository.getUser(id);
		}
		else
			return null;
	}
	
	public void delete(int id) {
		if(userRepository.containId(id)) {
			userRepository.delete(id);
			System.out.println("delete successfully ");
		}
		else
			System.err.println("Their is no such user ");
	}
	
	public void displayService() {
		List<User> list = userRepository.display();
		list.forEach(user -> System.out.println(user));
	}
	
}
