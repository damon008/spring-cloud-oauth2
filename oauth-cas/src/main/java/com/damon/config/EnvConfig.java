package com.damon.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 配置信息
 * @author Damon 
 * @date 2019年10月25日 下午1:54:01
 *
 */

@Component
@RefreshScope
public class EnvConfig {
	
	@Value("${jdbc.driverClassName:}")
    private String jdbc_driverClassName;
    
    @Value("${jdbc.url:}")
    private String jdbc_url;
    
    @Value("${jdbc.username:}")
    private String jdbc_username;
    
    @Value("${jdbc.password:}")
    private String jdbc_password;
    
	public String getJdbc_driverClassName() {
		return jdbc_driverClassName;
	}

	public void setJdbc_driverClassName(String jdbc_driverClassName) {
		this.jdbc_driverClassName = jdbc_driverClassName;
	}

	public String getJdbc_url() {
		return jdbc_url;
	}

	public void setJdbc_url(String jdbc_url) {
		this.jdbc_url = jdbc_url;
	}

	public String getJdbc_username() {
		return jdbc_username;
	}

	public void setJdbc_username(String jdbc_username) {
		this.jdbc_username = jdbc_username;
	}

	public String getJdbc_password() {
		return jdbc_password;
	}

	public void setJdbc_password(String jdbc_password) {
		this.jdbc_password = jdbc_password;
	}

}
