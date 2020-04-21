package com.damon.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.damon.commons.Response;
import com.damon.config.EnvConfig;
import com.damon.user.service.UserService;

/**
 * 
 * 
 * @author Damon 
 * @date 2020年1月13日 下午3:31:07
 *
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
    private EnvConfig envConfig;
	
	
    @GetMapping("/test")
    public String hello() {
        return envConfig.getTitle();
    }
	
    @GetMapping("/getCurrentUser")
    @PreAuthorize("hasAuthority('admin')")
    public Object getCurrentUser(Authentication authentication) {
    	logger.info("test password mode");
        return authentication;
    }

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/auth/admin")
    public Object adminAuth() {
    	logger.info("test password mode");
        return "Has admin auth!";
    }
    
    @GetMapping(value = "/get")
    @PreAuthorize("hasAuthority('admin')")
    //@PreAuthorize("hasRole('admin')")//无效
    public Object get(Authentication authentication){
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        authentication.getCredentials();
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)authentication.getDetails();
        String token = details.getTokenValue();
        return token;
    }
    
    @GetMapping("/getUserInfo")
    @PreAuthorize("hasAuthority('admin')")
    public Response<Object> getUserInfo(Authentication authentication) {
    	logger.info("test password mode");
    	Object principal = authentication.getPrincipal();
    	if(principal instanceof String) {
    		String username = (String) principal;
    		return userService.getUserByUsername(username);
    	}
		return null;
    }

}
