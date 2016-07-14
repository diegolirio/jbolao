package br.com.jbolao.jbolao.common;

import javax.servlet.http.HttpServletRequest;

public class HttpCommon {
	
	public static  String getURLServer(HttpServletRequest request) {
		int indexOf = request.getRequestURL().indexOf(request.getContextPath());
		String serverURL = request.getRequestURL().substring(0, indexOf);
		return serverURL;
	}

}
