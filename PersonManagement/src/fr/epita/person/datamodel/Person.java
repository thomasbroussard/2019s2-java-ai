package fr.epita.person.datamodel;

public class Person {
	private Double height;
	private Integer age;
	private String email;

	
	public Person(Double height, Integer age, String email) {
		this.height = height;
		this.age = age;
		this.email = email;
	}
	
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
