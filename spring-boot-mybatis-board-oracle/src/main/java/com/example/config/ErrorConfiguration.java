package com.example.config;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ErrorConfiguration extends ServerProperties {
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		super.customize(container);
//		container.addErrorPages(new ErrorPage(HttpStatus.UNAUTHORIZED, "/WEB-INF/error/401.jsp"));
		container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
//		container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/WEB-INF/error/500.jsp"));
	}
}
