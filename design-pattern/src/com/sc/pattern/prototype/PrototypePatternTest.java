package com.sc.pattern.prototype;

import java.util.List;

public class PrototypePatternTest {
	public static void main(String[] args) {
		User user = new User();
		user.getDataFromDB();

		User newUser = (User) user.clone();
		List<String> list1 = newUser.getUserList();
		list1.add("Sandy");
		
		User newUser1 = (User) user.clone();
		List<String> list2 = newUser1.getUserList();
		list2.remove("John");

		System.out.println("User List:" + user.getUserList());
		System.out.println("New User List:" + list1);
		System.out.println("New User 1 List:" + list2);
	}
}
