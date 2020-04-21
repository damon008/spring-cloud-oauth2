package com.damon.login.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.damon.commons.Response;
import com.damon.exception.InnerErrorException;

/**
 * @author  wangshoufa 
 * @date 2018年11月15日 上午11:59:24
 *
 */

public interface LoginService extends UserDetailsService {
	
	/**
	 * 
	 * Spring Security默认函数
	 * @param username
	 * @return
	 * @throws UsernameNotFoundException
	 * @author Damon 
	 * @throws InnerErrorException 
	 * @date 2020年1月13日
	 *
	 */
	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
	
	//以下自定义
	
	/**
	  * 功能描述：登录方法
	  * @param request req请求
	  * @param username 用户名 一般是邮箱
	  * @param password 密码
	  * @return com.damon.commons.Response<java.lang.Object> 返回登录结果
	  * @Author: guoliangbo
	  * @Date: 2019/4/22 14:47
	  */
	Response<Object> login(String username, String password);
	
	/**
	 * 
	 * 校验token合法性
	 * @param request
	 * @param token
	 * @return
	 * @author wangshoufa 
	 * @date 2019年8月15日
	 *
	 */
	Response<Object> verify(HttpServletRequest request, String token);

	Response<Object> updatePwd(HttpServletRequest req, String username, String oldPwd, String newPwd);

	//Response<Object> logout(HttpServletRequest req, HttpServletResponse res);
	
}
