package com.jts.pattern.builder;

public class UserBuilder {
	public static void main(String[] args) {
		User user = new User.UserBuilder("John", "Allen")
				.age(30)
				.address("US")
				.phone("1234567890")
				.build();
		
		System.out.println("User Object::"+user);
		
		user = new User.UserBuilder("John", "Allen")
				.age(30)
//				.address("US")
				.phone("1234567890")
				.build();
		
		System.out.println("User Object::"+user);
	}
}
