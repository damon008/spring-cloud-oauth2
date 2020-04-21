package com.damon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * @author Damon 
 * @date 2020年1月13日 下午3:23:06
 *
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.damon"})
@EnableDiscoveryClient
@EnableOAuth2Sso
public class ProviderApp {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApp.class, args);
    }

}
