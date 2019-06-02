package com.miaoshaproject.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.error.EmBusinessError;
import com.miaoshaproject.response.CommonReturnType;

public class BaseController {
	
	public static final String CONTENT_TYPE_FORMED = "application/x-www-form-urlencoded";
	/**
	 * The spring exception handler  to handler normal business exceptions
	 * @param request
	 * @param ex
	 * @return
	 */
	@ExceptionHandler
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Object handlerException(HttpServletRequest request, Exception ex) {
		
		Map<String, Object> responseData = new HashMap<String, Object>();
		if(ex instanceof BusinessException) {
			BusinessException businessException = (BusinessException)ex;
		
			responseData.put("errCode", businessException.getErrCode());
			responseData.put("errMsg", businessException.getErrMsg());
		}else {
			responseData.put("errCode", EmBusinessError.UNKNOWN_ERROR.getErrCode());
			responseData.put("errMsg", EmBusinessError.UNKNOWN_ERROR.getErrMsg());
		}
		
		return CommonReturnType.create(responseData, "fail");
	}
}
