package com.damon.login.dao;

import org.springframework.stereotype.Repository;

import com.damon.login.model.SysUser;

/**
*
*
* created by wangshoufa
* 2018年5月23日 下午4:05:21
*
*/
@Repository
public interface UserMapper {
	
	SysUser getUserByUsername(String username) throws Exception;

	SysUser login(String username, String password) throws Exception;

	int updatePwd(String username, String enCodeByMD5) throws Exception;
	
}
