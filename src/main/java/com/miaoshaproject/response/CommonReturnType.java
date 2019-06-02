package com.miaoshaproject.response;


public class CommonReturnType {
	// response status:  success, fail
	private String status;
	
	// when status was success, the data is the returned business json object
	// when status was fail, the data is the common error message body
	private Object data;
	
	public static CommonReturnType create(Object result) {
		return CommonReturnType.create(result, "success");
	}
	
	public static CommonReturnType create(Object result, String status) {
		CommonReturnType type = new CommonReturnType();
		type.setData(result);
		type.setStatus(status);
		return type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
	
}
