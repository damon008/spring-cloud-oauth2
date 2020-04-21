package com.damon.login.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.damon.commons.Response;
import com.damon.constant.Constant;
import com.damon.constant.LoginEnum;
import com.damon.login.service.LoginService;
import com.damon.utils.IpUtil;

import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.Api;

/**
 * 
 * @author Damon 
 * @date 2020年1月13日 下午2:35:16
 *
 */
@RestController
@RequestMapping("/api")
@Api(value = "LoginController", description = "登录")
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
    private ConsumerTokenServices consumerTokenServices;
	
    /*@GetMapping("/getCurrentUser")
    public Object getCurrentUser(Authentication authentication, HttpServletRequest request) {
    	logger.debug("start ...");
        String header = request.getHeader("Authorization");
        String token = StrUtil.subAfter(header, "bearer ", false);
        return Jwts.parser()
                .setSigningKey("test_jwt_sign_key".getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(token)
                .getBody();
    }*/
	
	//@PreAuthorize("hasAuthority('admin')")
    //@PreAuthorize("hasRole('admin')")
    @GetMapping("/user")
    public Principal user(Principal user) {
        //获取当前用户信息
        return user;
    }
	
    /**
     * 重写原生Oauth2的注销API
     * @param req
     * @param res
     * @return
     * @author Damon 
     * @date 2020年2月28日
     *
     */
	@DeleteMapping(value = "/logout")
	public Response<Object> logout(HttpServletRequest req, HttpServletResponse res) {
		logger.info("clientIp is: {}", IpUtil.getClientIp(req));
		logger.info("serverIp is: {}", IpUtil.getCurrentIp());
		//注销当前用户curl -i -H "Accept: application/json" -H "Authorization:bearer 6951422d-3739-4e3e-8e67-2c5e1aaff409" -X DELETE http://localhost:5555/oauth-cas/api/logout
		String header = req.getHeader("Authorization");
        String access_token = StrUtil.subAfter(header, "bearer ", false);
		
        //限制为授权之后的接口时，该种形式无法被调用，报错未授权
        //curl -i -H "Accept: application/json" -H "access_token:b5086c06-b4f1-41fd-bf0c-61e63683066e" -X DELETE http://localhost:5555/oauth-cas/api/logout
        //String access_token = req.getHeader("access_token");
		
        logger.info("access_token: {}", access_token);
		if(StringUtils.isBlank(access_token)) {
			return Response.error(Constant.RESPONSE_STATUS_SUCCESS, LoginEnum.LOGOUT_FAILED.getSeq(),
					LoginEnum.LOGOUT_FAILED.getDesc(), null);
		}
		if (consumerTokenServices.revokeToken(access_token)){
			return Response.ok(Constant.RESPONSE_STATUS_SUCCESS, LoginEnum.LOGOUT_SUCCESS.getSeq(),
					LoginEnum.LOGOUT_SUCCESS.getDesc(), null);
        }
		else {
        	return Response.error(Constant.RESPONSE_STATUS_SUCCESS, LoginEnum.LOGOUT_FAILED.getSeq(),
					LoginEnum.LOGOUT_FAILED.getDesc(), null);
        }
	}
	
	/**
	 * 
	 * 该方法Oauth2已经给做了，即为原生Oauth2的注销API
	 * 
	 * curl -i -H "Accept: application/json" -H "access_token:b5086c06-b4f1-41fd-bf0c-61e63683066e" -X GET http://10.10.1.5:5556/cas-server/api/logout
	 * @param req
	 * @param res
	 * @return
	 * @author Damon 
	 * @date 2020年1月16日
	 *
	 */
	/*@ApiOperation(value = "用户退出")
	@GetMapping(value = "/logout")
	public Response<Object> logout(HttpServletRequest req, HttpServletResponse res) {
		logger.info("/logout");
		logger.info("clientIp is: {}", IpUtil.getClientIp(req));
		logger.info("serverIp is: {}", IpUtil.getCurrentIp());
		String access_token = req.getHeader("access_token");
		logger.info("method logout access_token: {}", access_token);
		if(StringUtils.isBlank(access_token)) {
			return Response.error(Constant.RESPONSE_STATUS_SUCCESS, LoginEnum.LOGOUT_FAILED.getSeq(),
					LoginEnum.LOGOUT_FAILED.getDesc(), null);
		}
		if (consumerTokenServices.revokeToken(access_token)){
			return Response.ok(Constant.RESPONSE_STATUS_SUCCESS, LoginEnum.LOGOUT_SUCCESS.getSeq(),
					LoginEnum.LOGOUT_SUCCESS.getDesc(), null);
        }else {
        	return Response.error(Constant.RESPONSE_STATUS_SUCCESS, LoginEnum.LOGOUT_FAILED.getSeq(),
					LoginEnum.LOGOUT_FAILED.getDesc(), null);
        }
	}*/

}
