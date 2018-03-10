package org.prac.reflect;

public class TestBean {

	public String name;
	
	public String address;
	
	public TestBean() {
		this("","");
	}
	
	public TestBean(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return this.address;
	}
}
