package com.damon.exception;

/**
 * @author Damon 
 * @date 2020年4月1日 下午12:26:20
 *
 */

public class InnerErrorException extends Exception{
	
	String msg;
	/**
	 *
	 * @author Damon 
	 * @date 2020年4月1日
	 *
	 */
	
	public InnerErrorException (String msg){
        this.msg = msg;
    }
}
