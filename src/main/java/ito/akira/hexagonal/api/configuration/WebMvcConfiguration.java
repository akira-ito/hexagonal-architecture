package ito.akira.hexagonal.api.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import ito.akira.hexagonal.api.application.converter.ConverterSpringAllStudentQuery;
import ito.akira.hexagonal.api.application.converter.ConverterSpringCreateStudentDTO;
import ito.akira.hexagonal.api.application.converter.ConverterSpringStudentDTO;
import ito.akira.hexagonal.api.application.converter.ConverterSpringUpdateStatusStudentDTO;
import ito.akira.hexagonal.api.infraestructure.respository.convert.ConverterStudent;
import ito.akira.hexagonal.api.infraestructure.respository.convert.ConverterStudentEntity;

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	@Override
	protected void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new ConverterSpringAllStudentQuery());
		registry.addConverter(new ConverterSpringCreateStudentDTO());
		registry.addConverter(new ConverterSpringStudentDTO());
		registry.addConverter(new ConverterSpringUpdateStatusStudentDTO());
		

		registry.addConverter(new ConverterStudent());
		registry.addConverter(new ConverterStudentEntity());
	}
}
