package com.miaoshaproject.service.model;

public class UserModel {

	private Integer id;
	private String name;
	private Integer gender;
	private Integer age;
	private String telephone;
	private String registerMode;
	private String thirdPartyId;
	private String encrptPassword;
	
	public UserModel() {
	}
	
	public UserModel(Integer id, String name, Integer gender, Integer age, String telephone, String registerMode,
			String thirdPartyId, String encrptPassword) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.telephone = telephone;
		this.registerMode = registerMode;
		this.thirdPartyId = thirdPartyId;
		this.encrptPassword = encrptPassword;
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

	public String getRegisterMode() {
		return registerMode;
	}

	public void setRegisterMode(String registerMode) {
		this.registerMode = registerMode;
	}

	public String getThirdPartyId() {
		return thirdPartyId;
	}

	public void setThirdPartyId(String thirdPartyId) {
		this.thirdPartyId = thirdPartyId;
	}

	public String getEncrptPassword() {
		return encrptPassword;
	}

	public void setEncrptPassword(String encrptPassword) {
		this.encrptPassword = encrptPassword;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", telephone="
				+ telephone + ", registerMode=" + registerMode + ", thirdPartyId=" + thirdPartyId + ", encrptPassword="
				+ encrptPassword + "]";
	}

}
