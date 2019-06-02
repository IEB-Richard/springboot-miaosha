package com.miaoshaproject.error;

/**
 * Decorator of business error
 * @author xiaoqiangliu
 *
 */
public class BusinessException extends Exception implements CommonError {
	
	private static final long serialVersionUID = 1L;
	private CommonError commonError;
	
	/**
	 * Constructor the BusinessException with CommonError
	 * 
	 * Please note: here we have to call super().
	 * @param commonError
	 */
	public BusinessException(CommonError commonError) {
		super();
		this.commonError = commonError;
	}
	
	public BusinessException(CommonError commonError, String errMsg) {
		super();
		this.commonError = commonError;
		this.commonError.setErrMsg(errMsg);
	}


	@Override
	public int getErrCode() {
		return this.commonError.getErrCode();
	}

	@Override
	public String getErrMsg() {
		return this.commonError.getErrMsg();
	}

	@Override
	public CommonError setErrMsg(String errMsg) {
		return this.commonError.setErrMsg(errMsg);
	}

}
