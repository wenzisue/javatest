package com.xiaowen.javatest;

public class User {
	private String userName;
	private int age;
	private String address;
	private int phone;
	
	// my first example of using a builder for a class
	
	public static class Builder {
		//Required parameters
		private String userName;
		private int age;
		private String address;
		
		//Optional parameters
		private int phone;

		public Builder (String name,  int age, String address) {
			this.address = address;
			this.userName = name;
			this.age = age;
		}

		public Builder addPhoneNumber(int i) {
			this.phone = i;
			return this;
		}
		
		public User build() {
			return new User(this);
		}
	}
	
	private User(Builder builder) {
		userName = builder.userName;
		address = builder.address;
		age = builder.age;
		phone = builder.phone;
	}
}
