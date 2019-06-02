package com.miaoshaproject.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaoshaproject.dao.UserDOMapper;
import com.miaoshaproject.dao.UserPasswordDOMapper;
import com.miaoshaproject.dataobject.UserDO;
import com.miaoshaproject.dataobject.UserPasswordDO;
import com.miaoshaproject.service.UserService;
import com.miaoshaproject.service.model.UserModel;

/**
 * 
 * @author xiaoqiangliu
 *
 */

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDOMapper userDOMapper;
	
	@Autowired
	private UserPasswordDOMapper userPasswordDOMapper;

	@Override
	public UserModel getUserById(Integer id) {
		
		UserDO userDO = userDOMapper.selectByPrimaryKey(id);
		if(userDO == null) {
			return null;
		}
		
		// get user password by userId
		UserPasswordDO userPasswordDO = userPasswordDOMapper.selectByUserId(userDO.getId());
		
		// combine userDO and userPasswordDO to generate userModel
		UserModel userModel = convertFromDataObject(userDO, userPasswordDO);
		
		return userModel;
	}
	
	private UserModel convertFromDataObject(UserDO userDO, UserPasswordDO userPasswordDO) {
		if(userDO  == null) {
			return null;
		}
		UserModel userModel = new UserModel();
		BeanUtils.copyProperties(userDO, userModel);
		
		if(userPasswordDO != null) {
			userModel.setEncrptPassword(userPasswordDO.getEncrptPassword());
		}
		return userModel;
	}
}
