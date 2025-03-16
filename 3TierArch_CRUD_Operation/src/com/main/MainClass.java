package com.main;

import java.util.Scanner;

import com.Service.UserService;
import com.controller.UserController;
import com.repository.UserRepository;

public class MainClass {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//configation object in Dependency injection
		UserRepository userRepository = new UserRepository();
		UserService userService = new UserService(userRepository);
		UserController userController = new UserController(userService);
		
		boolean run = true;
		
		while(run) {
			System.out.println("enter your option \n1. Create user\n2. Get user \n3. Delete User \n4. print all user \n5. exit");
			int option = scanner.nextInt();
			scanner.nextLine();
			
			switch(option) {
				case 1:
					userController.createUser(scanner);
					break;
				case 2:
					userController.getUser(scanner);
					break;
				case 3:
					userController.deleteUser(scanner);
					break;
				case 4:
					userController.displayerALLUser();
					break;
				case 5:
					System.out.println("thank you ");
					run = false;
			}
		}
		scanner.close();
		
	}

}
