package com.ad.core.user.springconfig;

import com.ad.core.user.service.PersonService;
import org.mockito.Mockito;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = { "com.ad.core.user.util" })
public class ControllerTestConfig {

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public PersonService mockPersonService() {
		return Mockito.mock(PersonService.class);
	}
	
}
