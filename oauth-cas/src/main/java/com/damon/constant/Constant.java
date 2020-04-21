package com.damon.constant;

/**
 * 常量表
 * @author  wangshoufa 
 * @date 2018年11月12日 上午11:07:29
 *
 */
public class Constant {
	/**
	 * 200  访问成功
	 * 202  已经接受请求，但未处理完成
	 * 500  服务器出错
	 * 404  链接无效
	 * 400  客户端请求的语法错误，服务器无法理解
	 * 401  请求要求用户的身份认证
	 * 409  服务器完成客户端的PUT请求是可能返回此代码，服务器处理请求时发生了冲突
	 */
	public final static int RESPONSE_STATUS_SUCCESS = 200;
	public final static int RESPONSE_STATUS_ACCEPTED = 202;
	public final static int RESPONSE_STATUS_SERVER_ERROR = 500;
	public final static int RESPONSE_STATUS_INVALID_LINK = 404;
	public final static int RESPONSE_STATUS_BAD_REQUEST_ERROR = 400;
	public final static int RESPONSE_STATUS_UNAUTHORIZED_ERROR = 401;
	public final static int RESPONSE_STATUS_CONFLICT_ERROR = 409;

}

