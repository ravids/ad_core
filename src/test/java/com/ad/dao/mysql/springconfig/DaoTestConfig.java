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
@ComponentScan(basePackages = { "com.ad.core.model.user.dao", "com.ad.core.dao.sql.*", "com.ad.core.model.user.domain" })
public class DaoTestConfig {

}
