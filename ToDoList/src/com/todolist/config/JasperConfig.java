package com.todolist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;


@Configuration
public class JasperConfig {

	@Bean(name = "pdfReport")
	public JasperReportsPdfView pdfReport(){
		JasperReportsPdfView jasperReportsPdfView = new JasperReportsPdfView();
		jasperReportsPdfView.setUrl("");
		jasperReportsPdfView.setReportDataKey("datasource");
		
		return jasperReportsPdfView;
	}
	
	
	
	
	
}
