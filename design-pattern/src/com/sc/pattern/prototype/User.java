package com.sc.pattern.prototype;

import java.util.ArrayList;
import java.util.List;

public class User implements Cloneable {

	private List<String> userList;

	public User() {
		userList = new ArrayList<>();
	}

	public User(List<String> userList) {
		this.userList = userList;
	}

	public void getDataFromDB() {
		System.out.println("Fetching data from database");

		userList.add("Olive");
		userList.add("Paddy");
		userList.add("John");
	}

	public List<String> getUserList() {
		return userList;
	}

	@Override
	public Object clone() {
		List<String> newUserList = new ArrayList<>();

		for (String user : getUserList()) {
			newUserList.add(user);
		}

		return new User(newUserList);

	}

}
