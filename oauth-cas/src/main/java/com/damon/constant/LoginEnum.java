package com.damon.constant;

/**
 * @author  wangshoufa 
 * @date 2018年11月15日 下午1:15:36
 *
 */

public enum LoginEnum {
	
	LOGIN_SUCCESS(0,"login success"),
	
	LOGIN_TIMEOUT(-1,"login timeout"),
	
	LOGIN_FAILED(-2,"login failed"),
	
	LOGOUT_SUCCESS(0,"logout success"),
	
	LOGOUT_FAILED(-1,"logout failed"),

	EMAIL_ERROR(2,"email error"),
	
	PASSWORD_LENGTH_ERROR(3,"pwd length error"),
	
	PASSWORD_ERROR(4,"pwd error"),
	
	USER_NOT_EXIST(5, "user not exist"),

	USER_NOT_DEVELOPER(6, "user is not dev"),
	
	UNKNOWN_ERROR(7, "unknown error");   // 未知异常
	
	private Integer seq;

    private String desc;

    LoginEnum(Integer seq, String desc) {
        this.seq = seq;
        this.desc = desc;
    }

	public int getSeq() {
		return seq;
	}

	public String getDesc() {
		return desc;
	}

}
