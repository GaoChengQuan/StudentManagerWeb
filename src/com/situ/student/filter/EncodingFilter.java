package com.situ.student.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncodingFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		//在request.getParameter("name")之前处理好乱码
		//装饰者设计模式，在原来的基础上装饰一下，在调getParameter时处理好乱码
		EnhancedRequest enhancedRequest = new EnhancedRequest(req);
		
		chain.doFilter(enhancedRequest, response);
	}

	@Override
	public void destroy() {
	}
}

class EnhancedRequest extends HttpServletRequestWrapper {
	private HttpServletRequest request;

	public EnhancedRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	
	@Override
	public String getParameter(String name) {
		String parameter = request.getParameter(name);//还是乱码
		if (parameter != null && !parameter.equals("")) {
			try {
				parameter = new String(parameter.getBytes("iso8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return parameter;
	}
}



