package com.ad.core.dao.sql.company;

import com.ad.core.model.company.dao.CompanyLessonDao;
import com.ad.core.model.company.domain.CompanyLesson;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.WebApplicationInitializer;

/**
 * Created by mnavarro on 05/11/2014.
 */
@Repository
public class CompanyLessonDaoImpl implements CompanyLessonDao
{
    protected static final Logger logger = LoggerFactory.getLogger(WebApplicationInitializer.class);

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
        } catch ( HibernateException he ) {
            session = sessionFactory.openSession();
        }
        return session;
    }

    @Override
    public void save(CompanyLesson lesson) {
        getCurrentSession().save(lesson);
        logger.info("company lesson created::" , lesson);
    }
}
