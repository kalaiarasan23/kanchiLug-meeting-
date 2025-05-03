package main.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import main.Service.UserService;
import main.entity.User;

//Presentation layer.
public class UserController {
	UserService userService;
	
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	public void createUser(Scanner scanner) {
		System.out.println("enter Your name ");
		String name = scanner.nextLine();
		
		System.out.println("enter your age ");
		int age = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("enter username ");
		String userName = scanner.nextLine();
		
		System.out.println("enter password ");
		String password = scanner.nextLine();
		
		System.out.println("enter phone number ");
		String number = scanner.nextLine();
		
		User u = new User(age, number, name, userName, password);
		
		userService.addUser(u);
		System.out.println("user id is "+u.getId());
	}
	
	public void getUser(Scanner scanner) {
		User u = null;
		try {
			System.out.println("enter your user id");
			int id = scanner.nextInt();
			scanner.nextLine();
			
			u = userService.getUser(id);
			System.out.println(u);
			if(u == null)
			{
				System.err.println("your id is invalid \n");
				return;
			}
			userOperation(u,scanner);
			System.out.println(u.getName()+" bye, see you again");
		}
		catch(InputMismatchException e) {
			System.err.println("wrong input entered ");
		}
	}
	
	public void userOperation(User u, Scanner scanner) {
		try {
			System.out.println("enter number \n1. display user details \n2. change phone number \n3. change username \n4. change password ");
			int option = scanner.nextInt();
			scanner.nextLine();
			switch(option) {
			case 1:
				display(u);
				break;
			case 2:
				System.out.println("enter your new phone number ");
				String number = scanner.nextLine();
				u.setPhoneNumber(number);
				System.out.println("number successfully changed ");
				break;
			case 3:
				System.out.println("enter your new username number ");
				String username = scanner.nextLine();
				u.setUserName(username);
				System.out.println("number successfully changed \n");
				break;
			case 4:
				System.out.println("enter your new phone number \n");
				String password = scanner.nextLine();
				u.setPassword(password);
				System.out.println("password successfully changed \n");
				break;
			default:
				System.out.println("wrong  number");
			}
			System.out.println("do you want to continue y/n");
			char c = scanner.next().charAt(0);
			if(c == 'y')
				userOperation(u, scanner);
		}catch(InputMismatchException e) {
			System.err.println("wrong input entered ");
		}
		System.out.println();
	}

	private void display(User u) {
		System.out.println("Id "+ u.getId());
		System.out.println("name "+ u.getName());
		System.out.println("age "+ u.getAge());
		System.out.println("phoneNumber "+ u.getPhoneNumber());
		System.out.println("UserName "+ u.getUserName());
		System.out.println("password "+ u.getPassword());
		System.out.println();
	}

	public void deleteUser(Scanner scanner) {
		System.out.println("enter the User id");
		int id = scanner.nextInt();
		scanner.nextLine();
		userService.delete(id);
		System.out.println();
	}

	public void displayerALLUser() {
		userService.displayService();
		System.out.println();
	}
	
}
