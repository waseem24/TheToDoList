package com.todolist.config;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"com.todolist"})
@Import(value = { WebSecurityConfig.class,JasperConfig.class })

public class WebAppConfig extends WebMvcConfigurerAdapter{
	
	@Autowired
	ServletContext servletContext;
	
	
	 @Override
	    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	        configurer.enable();
	    }
	 
	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	    }
	    
	    @Bean
	    public XmlViewResolver getXmlViewResolver(){
	    	XmlViewResolver xmlViewResolver = new XmlViewResolver();
	    	xmlViewResolver.setOrder(0);
	    	xmlViewResolver.setLocation(new ServletContextResource(servletContext, "classpath:com/todolist/config/JasperConfig.java"));
			return xmlViewResolver;
	    }
	    
	    @Bean
	    public StandardServletMultipartResolver multipartResolver(){
	        return new StandardServletMultipartResolver();
	    }
	    
	    @Bean
	    public InternalResourceViewResolver getInternalResourceViewResolver() {
	        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	        resolver.setPrefix("/WEB-INF/pages/");
	        resolver.setSuffix(".jsp");
	        return resolver;
	    }

}
