package com.erp.springboot.backend.models.entidades;

import com.erp.springboot.backend.controllers.back_end_spring_rest.BackEndSpringRestApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BackEndSpringRestApplication.class);
	}

}
