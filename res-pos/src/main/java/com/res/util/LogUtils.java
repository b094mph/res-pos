package com.res.util;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.MDC;

public class LogUtils {

	public static void initLog(HttpServletRequest request){
		MDC.clear();
		MDC.put("localName", request.getLocalName());
		MDC.put("serverName", request.getServerName());
		MDC.put("remoteHost", request.getRemoteHost());
	}
}
