package org.prac.reflect;

public class TestPerson {
	
	private String name;
	
	private String address;
	
	private int age;
	
	private String birthDay;
	
	public TestPerson(String name, String address, int age, String birthDay) {
		this.setName(name);
		this.setAddress(address);
		this.setAge(age);
		this.setBirthDay(birthDay);
	}
	
	public TestPerson() {
		this("Unknown", "Unknown", 0, "Unknown" );
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

}
