package com.miaoshaproject.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miaoshaproject.controller.viewobject.UserVO;
import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.error.EmBusinessError;
import com.miaoshaproject.response.CommonReturnType;
import com.miaoshaproject.service.UserService;
import com.miaoshaproject.service.model.UserModel;

@Controller("user")
@RequestMapping("/user")
@CrossOrigin
public class UserController extends BaseController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpServletRequest httpServletRequest;
	
	// getOtp - Generate one-time-password code and send to user via SMS message
	@RequestMapping(value="/getotp", method= {RequestMethod.POST}, consumes=CONTENT_TYPE_FORMED)
	@ResponseBody
	public CommonReturnType getOtp(@RequestParam(name="telephone") String telephone) {
		
		// generate one-time-password verification code according to rules
		Random random = new Random();
		int randomInt = random.nextInt(99999);
		randomInt += 10000;
		String otpCode = String.valueOf(randomInt);
		
		// bind the verification code to user's phone number, (temp solution: via http session)
		httpServletRequest.getSession().setAttribute(telephone, otpCode);
		
		// then send the verification code to user via SMS message(omit)
		System.out.println("telephone = " + telephone + " & otp code: " + otpCode);
		
		return CommonReturnType.create(null);
	}


	@RequestMapping("/get")
	@ResponseBody
	public CommonReturnType getUser(@RequestParam(name="id") Integer id) throws BusinessException {
		
		// get the Model object
		UserModel userModel = userService.getUserById(id);
		
		if(userModel == null) {
			throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
			// userModel.setEncrptPassword("1234");
		}
		
		// get the UI view object
		UserVO userVO = convertFromModel(userModel);
		
		// return the common return type object as result
		return CommonReturnType.create(userVO);
	}
	
	private UserVO convertFromModel(UserModel userModel) {
		if(userModel == null) {
			return null;
		}
		UserVO userVO = new UserVO();
		BeanUtils.copyProperties(userModel, userVO);
		return userVO;
	}
	
}
