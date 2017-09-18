package com.zhiyou100.ssh.model;

public class Result {
	
	private boolean success;
    private String  msg;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "Result [success=" + success + ", msg=" + msg + "]";
	}
	
	

}
