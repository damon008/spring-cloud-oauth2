package com.damon.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * 
 * SpringSecurity配置
 * @author Damon 
 * @date 2020年1月13日 下午3:03:55
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                //开启授权认证
                .authorizeRequests()
                .antMatchers("/oauth/**", "/login/**")//"/logout/**"
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                //登陆配置
                .formLogin()
                .permitAll()
                .and()
                
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                ;
    }
    
    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder());
    }*/

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/public/", "/static/", "/css/**", "/js/**", "/plugins/**", "/favicon.ico");
    }
}
