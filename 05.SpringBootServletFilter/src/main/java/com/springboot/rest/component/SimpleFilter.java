package com.springboot.rest.component;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;

@Component
public class SimpleFilter implements Filter {
	@Override
	public void destroy() {
		System.out.println("***************destroy*******************");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain)
			throws IOException, ServletException {

		System.out.println("***************doFilter*******************");
		System.out.println("Remote Host:" + request.getRemoteHost());
		System.out.println("Remote Address:" + request.getRemoteAddr());
		filterchain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterconfig) throws ServletException {
		System.out.println("***************init*******************");
	}
}