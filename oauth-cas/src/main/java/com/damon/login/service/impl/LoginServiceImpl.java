package com.damon.login.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.stereotype.Service;

import com.damon.commons.Response;
import com.damon.constant.Constant;
import com.damon.constant.LoginEnum;
import com.damon.exception.InnerErrorException;
import com.damon.login.dao.UserMapper;
import com.damon.login.model.SysUser;
import com.damon.login.service.LoginService;
import com.damon.utils.IpUtil;
import com.google.common.collect.Lists;

/**
 * @author wangshoufa
 * @date 2018年11月15日 下午12:01:53
 *
 */
@Service
public class LoginServiceImpl implements LoginService {

	Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

	
	//private List<User> userList;
    
	@Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
	private UserMapper userMapper;
    
    @Autowired
    private HttpServletRequest req;
    
    /*@PostConstruct
    public void initData() {
        String password = passwordEncoder.encode("123456");
        userList = new ArrayList<>();
        userList.add(new User("damon", password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin")));
        userList.add(new User("joe", password, AuthorityUtils.commaSeparatedStringToAuthorityList("client")));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	logger.debug("excute time", new Date());
        List<User> findUserList = userList.stream().filter(user -> user.getUsername().equals(username)).collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(findUserList)) {
            return findUserList.get(0);
        } else {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
    }*/
    
    /**
     * Auth
     * 登录认证
     * 实际中从数据库获取信息
     * 这里为了做演示，把用户名、密码和所属角色都写在代码里了，正式环境中，这里应该是从数据库或者其他地方根据用户名将加密后的密码及所属角色查出来的。账号 damon ，
     * 密码123456，稍后在换取 token 的时候会用到。并且给这个用户设置 "ROLE_ADMIN" 角色。
     * 
     */
    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	logger.info("clientIp is: {} ,username: {}", IpUtil.getClientIp(req), username);
		logger.info("serverIp is: {}", IpUtil.getCurrentIp());
		// 查询数据库操作
		try {
			SysUser user = userMapper.getUserByUsername(username);
			if (user == null) {
				logger.error("user not exist");
				throw new UsernameNotFoundException("username is not exist");
				//throw new UsernameNotFoundException("the user is not found");
			}
			else {
				// 用户角色也应在数据库中获取，这里简化
				String role = "";
				if(user.getIsAdmin() == 1) {
					role = "admin";
				}
				List<SimpleGrantedAuthority> authorities = Lists.newArrayList();
				authorities.add(new SimpleGrantedAuthority(role));
				//String password = passwordEncoder.encode("123456");// 123456是密码
				//return new User(username, password, authorities);
				// 线上环境应该通过用户名查询数据库获取加密后的密码
				return new User(username, user.getPassword(), authorities);
			}
		} catch (Exception e) {
			logger.error("database collect failed");
			logger.error(e.getMessage(), e);
			throw new UsernameNotFoundException(e.getMessage());
		}
	}

	@Override
	public Response<Object> login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<Object> verify(HttpServletRequest request, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<Object> updatePwd(HttpServletRequest req, String username, String oldPwd, String newPwd) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public Response<Object> logout(HttpServletRequest req, HttpServletResponse res) {
		return null;
	}*/
	
}
