package com.ad.dao.mysql.springconfig;

import com.google.common.base.Preconditions;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:persistence-mysql.properties" })
@ComponentScan({"com.ad.core.model.user.domain", "com.ad.core.model.company.domain"})
public class PersistenceConfig {

    @Autowired
    private Environment env;

//    public PersistenceConfig() {
//        super();
//    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.ad.core.model.user.domain", "com.ad.core.model.company.domain"});
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

//    @Bean
//    public DataSource dataSource() {
//        final BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName(Preconditions.checkNotNull(env.getProperty("jdbc.driverClassName")));
//        dataSource.setUrl(Preconditions.checkNotNull(env.getProperty("jdbc.url")));
//        dataSource.setUsername(Preconditions.checkNotNull(env.getProperty("jdbc.user")));
//        dataSource.setPassword(Preconditions.checkNotNull(env.getProperty("jdbc.pass")));
//
//        return dataSource;
//    }

    @Bean
    public DataSource dataSource() {
        DataSource dataSource = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("classpath:user.sql")
                        // .addScript("classpath:schemaDump.sql")
                .build();

        return dataSource;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(final SessionFactory sessionFactory) {
        final HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);

        return txManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    final Properties hibernateProperties() {
        final Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));

        hibernateProperties.setProperty("hibernate.show_sql", "true");
        // hibernateProperties.setProperty("hibernate.format_sql", "true");
        // hibernateProperties.setProperty("hibernate.globally_quoted_identifiers", "true");

        return hibernateProperties;
    }

}