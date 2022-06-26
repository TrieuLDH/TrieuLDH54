package it16306.assignment.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import it16306.assignment.interceptors.AuthenInterceptorLogin;

@Configuration
public class InterCeptorConfig implements WebMvcConfigurer{
	@Autowired
	private AuthenInterceptorLogin authen;
	
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authen)
			.addPathPatterns("/admin/**")
			.excludePathPatterns("/login");
	}
}
