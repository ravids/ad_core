package com.ad.core.user.springconfig;

import com.ad.core.user.dao.PersonDao;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Bootstrap for service layer.
 * 
 * @author RD
 */
@Configuration
@ComponentScan(basePackages = { "com.ad.core.user.service" })
public class ServiceTestConfig {

	@Bean
	public PersonDao mockPersonDao() {
		return Mockito.mock(PersonDao.class);
	}
	
}
