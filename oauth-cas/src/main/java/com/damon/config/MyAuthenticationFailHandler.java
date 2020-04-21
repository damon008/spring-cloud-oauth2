package com.damon.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.damon.login.controller.LoginController;
import com.damon.commons.Response;

/**
 * 
 * 自定义登录失败处理器
 * @author Damon 
 * @date 2020年1月15日 下午3:18:13
 *
 */
//@Component
public class MyAuthenticationFailHandler extends SimpleUrlAuthenticationFailureHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(MyAuthenticationFailHandler.class);
	
	/**
	 *
	 * @author Damon 
	 * @date 2020年1月15日
	 *
	 */
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// 设置状态码
		response.setStatus(HttpStatus.OK.value());
		response.setContentType("application/json;charset=UTF-8");
		// 将 登录失败 信息打包成json格式返回
		response.getWriter().write(JSON.toJSONString(Response.ok(200, -1, exception.getMessage())));
		//JSON.toJSONString(ServerResponse.createByErrorMessage(exception.getMessage())));
		//返回false表示不执行后续的过滤器，直接返回跳转到登录页面
        //HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
        //httpServletResponse.getWriter().write(JSON.toJSONString(Response.ok(200, 0, "logout success")));
		//response.getWriter().write(JSON.toJSONString(ServerResponse.createByErrorMessage(exception.getMessage())));
		
		//res.getWriter().write(JSON.toJSONString(Response.ok(200, -1, "login timeout")));
	}
}
