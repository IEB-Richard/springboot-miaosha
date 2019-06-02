package com.miaoshaproject.error;

public enum EmBusinessError implements CommonError {
	
	// a general error type, the errMsg could be changed by setErrMsg
	// with code start from 10001
	PARAMETER_VALIDATION_ERROR(10001, "Parameter validation error"),
	UNKNOWN_ERROR(10002, "unknown error"),
	
	// specific error types with code start from 20001
	USER_NOT_EXIST(20001, "User not exist"), ;
	
	private EmBusinessError(int errCode, String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}
	
	private int errCode;
	private String errMsg;
	
	@Override
	public int getErrCode() {
		return this.errCode;
	}

	@Override
	public String getErrMsg() {
		return this.errMsg;
	}

	@Override
	public CommonError setErrMsg(String errMsg) {
		this.errMsg = errMsg;
		return this;
	}

}
