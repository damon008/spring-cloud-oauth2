package com.damon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * 
 * 资源服务器配置
 * @author Damon 
 * @date 2020年1月13日 下午3:03:48
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
	
	
	/*@Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
    
	@Autowired
    private MyAuthenticationFailHandler myAuthenticationFailHandler;
    
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
        //表单登录 方式
        http.formLogin()
                .loginPage("/authentication/require")
                //登录需要经过的url请求
                .loginProcessingUrl("/authentication/form")
                .successHandler(myAuthenticationSuccessHandler)
                .failureHandler(myAuthenticationFailHandler);

        http.authorizeRequests()
                .antMatchers("/api/*")
                .authenticated()
                .antMatchers("/oauth/token").permitAll()
                .anyRequest()
                .permitAll()
                .and()
                //关闭跨站请求防护
                .csrf().disable();
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
