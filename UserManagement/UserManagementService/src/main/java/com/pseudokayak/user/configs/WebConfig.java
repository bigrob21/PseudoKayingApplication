package com.pseudokayak.user.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("com.pseudokayak.user.controller")
public class WebConfig implements WebMvcConfigurer  {

	 @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	        .allowCredentials(true)
	        .allowedOrigins("*")
	        .allowedHeaders("*")
	        .allowedMethods(RequestMethod.GET.name(),
	        				RequestMethod.POST.name(),
	        				RequestMethod.PATCH.name(),
	        				RequestMethod.PUT.name(),	
	        				RequestMethod.DELETE.name(),
	        				RequestMethod.OPTIONS.name(),
	        				RequestMethod.HEAD.name()
	        				);
	    }

}
