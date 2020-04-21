package com.damon.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * 
 * 
 * @author Damon 
 * @date 2020年1月16日 下午6:28:35
 *
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
        
                .exceptionHandling()
        		.authenticationEntryPoint(new AuthenticationEntryPointHandle())
        		//.authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
        		.and()
        
                .requestMatchers().antMatchers("/api/**")
                .and()
                .authorizeRequests()
                .antMatchers("/api/**").authenticated()
                .and()
                .httpBasic();
    }
	
    /*@Override
    public void configure(HttpSecurity http) throws Exception {
    	http
    		//.csrf().disable()
    		//.exceptionHandling()
			//.authenticationEntryPoint(new JWTAuthenticationEntryPoint())
			//.authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
        	//.and()
        	
        	.authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .requestMatchers()
            .antMatchers("/api/**");//配置需要保护的资源路径
    }*/
    
    /*@Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .requestMatchers()
                .antMatchers("/api/**");//配置需要保护的资源路径
    }*/
}
