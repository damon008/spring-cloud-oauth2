package com.damon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * 
 * 配置最多的就是认证服务端，验证账号、密码，存储 token，检查 token ,刷新 token 等都是认证服务端的工作
 * @author Damon 
 * @date 2020年1月13日 下午2:29:42
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.damon"})
@EnableDiscoveryClient
public class CasApp {
	public static void main(String[] args) {
		SpringApplication.run(CasApp.class, args);
	}
}
