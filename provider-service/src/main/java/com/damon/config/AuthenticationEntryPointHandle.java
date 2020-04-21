package com.damon.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.alibaba.fastjson.JSON;
import com.damon.commons.Response;

/**
 * 
 * 统一结果处理
 * 
 * @author Damon 
 * @date 2020年1月16日 上午11:11:44
 *
 */

public class AuthenticationEntryPointHandle implements AuthenticationEntryPoint {
	/**
	 *
	 * @author Damon
	 * @date 2020年1月16日
	 *
	 */
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {

		//response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		//response.setStatus(HttpStatus.OK.value());
		
        //response.setHeader("Access-Control-Allow-Origin", "*");  //gateway已加，无需再加
        //response.setHeader("Access-Control-Allow-Headers", "token");
        //解决低危漏洞点击劫持 X-Frame-Options Header未配置
        response.setHeader("X-Frame-Options", "SAMEORIGIN");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
		
		response.getWriter()
		.write(JSON.toJSONString(Response.ok(response.getStatus(), -2, authException.getMessage(), null)));
		/*response.getWriter()
				.write(JSON.toJSONString(Response.ok(200, -2, "Internal Server Error", authException.getMessage())));*/
	}
	
	/*@Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		response.getWriter()
				.write(JSON.toJSONString(Response.ok(200, -2, "Internal Server Error", authException.getMessage())));
	}*/
}
