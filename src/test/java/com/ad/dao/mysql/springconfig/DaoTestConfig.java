package com.ad.dao.mysql.springconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Bootstrap for service layer.
 * 
 * @author RD
 */
@Configuration
@Import(DatabaseTestConfig.class)
@ComponentScan(basePackages = { "com.ad.core.user.dao", "com.ad.core.dao.mysql.*", "com.ad.core.user.domain" })
public class DaoTestConfig {

}
