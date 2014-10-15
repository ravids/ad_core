package com.ad.core.user.springconfig;

import com.ad.core.user.bootstrap.DatabaseConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Bootstrap for service layer.
 * 
 * @author RD
 */
@Configuration
@Import(DatabaseConfig.class)
@ComponentScan(basePackages = { "com.ad.core.user.dao", "com.ad.core.user.domain" })
public class DaoTestConfig {

}
