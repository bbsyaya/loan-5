package com.loan.api.annotation.resolver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class BaseAnnotationsResolver{
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(BaseAnnotationsResolver.class);
	
	@Autowired
	private RequestMappingHandlerMapping handlerMapping;
	
	public Method baseResolver(HttpServletRequest req,
			HttpServletResponse res) {
		HandlerExecutionChain handlerChain = null;
		Object handler = null;
		try {
			handlerChain = handlerMapping.getHandler(req);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (handlerChain == null) {
			return null;
		} else {
			handler = handlerChain.getHandler();
			if (handler == null) {
				return null;
			}
		}
		if (!(handler instanceof HandlerMethod)) {
			return null;
		}	
		
		return ((HandlerMethod)handler).getMethod();
	}
}
