package com.ad.core.dao.sql.company;

//import com.ad.core.dao.hibernate.DaoAbstract;
import com.ad.core.model.company.dao.CompanyCourseDao;
import com.ad.core.model.company.domain.CompanyCourse;
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
 * Created by sabrishamkar on 11/4/14.
 */
@Repository
public class CompanyCourseDaoImpl implements CompanyCourseDao {


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
    public void save(CompanyCourse companyCourse) {
        getCurrentSession().save(companyCourse);
        logger.info("company course created::" , companyCourse);
    }
}
