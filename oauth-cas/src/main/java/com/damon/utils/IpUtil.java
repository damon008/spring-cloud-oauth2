package com.damon.utils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author  wangshoufa 
 * @date 2018年11月9日 上午10:26:29
 *
 */

public class IpUtil {
	/**
	 * @description 获取服务器地址
	 * @return
     * @author  wangshoufa 
     * @date 2018年11月9日 上午10:26:29
	 */
	public static InetAddress getCurrentIp() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) networkInterfaces.nextElement();
                Enumeration<InetAddress> nias = ni.getInetAddresses();
                while (nias.hasMoreElements()) {
                    InetAddress ia = (InetAddress) nias.nextElement();
                    if (!ia.isLinkLocalAddress() && !ia.isLoopbackAddress() && ia instanceof Inet4Address) {
                        return ia;
                    }
                }
            }
        } catch (SocketException e) {
        }
        return null;
    }
	/**
	 * @description 获取客户端请求的ip地址
	 * @param request
	 * @return
     * @author  wangshoufa 
     * @date 2018年11月9日 上午10:26:29
	 */
	public static String getClientIp(HttpServletRequest request) {
		String loginip = "";
		if (request.getHeader("x-forwarded-for") == null) {
			loginip = request.getRemoteAddr();
		} else {
			loginip = request.getHeader("x-forwarded-for");
		}
		return loginip;
	}

}
