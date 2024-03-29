package com.miaoshaproject.controller.viewobject;

public class UserVO {
	private Integer id;
	private String name;
	private Integer gender;
	private Integer age;
	private String telephone;
	
	public UserVO() {
	}
	public UserVO(Integer id, String name, Integer gender, Integer age, String telephone) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.telephone = telephone;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", telephone="
				+ telephone + "]";
	}
	
}
