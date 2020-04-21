package com.damon.exception;

import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author Damon 
 * @date 2020年3月13日 下午4:30:20
 *
 */

@JsonSerialize(using = UserOAuth2ExceptionSerializer.class)
public class UserOAuth2Exception extends OAuth2Exception {
    private Integer status = 400;

    public UserOAuth2Exception(String message, Throwable t) {
        super(message, t);
        status = ((OAuth2Exception)t).getHttpErrorCode();
    }

    public UserOAuth2Exception(String message) {
        super(message);
    }
    @Override
    public int getHttpErrorCode() {
        return status;
    }

}
