package com.miaoshaproject.service;

import com.miaoshaproject.service.model.UserModel;

public interface UserService {
	// get user by Id
	UserModel getUserById(Integer id);
}
