package com.ad.core.dao.sql.company;

import com.ad.core.model.company.dao.CompanyCourseDao;
import com.ad.core.model.company.domain.CompanyCourse;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.WebApplicationInitializer;

import java.util.List;

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
    public CompanyCourse findByCompanyIdAndCoCourseId(Integer companyId, Integer coCourseId) {
        String hsql = "from com.ad.core.model.company.domain.CompanyCourse cc"
                        + " where cc.CompanyId = :companyId"
                        + " and cc.CoCourseId = :coCourseId";
        Query query = getCurrentSession()
                .createQuery(hsql)
                .setParameter("companyId", companyId)
                .setParameter("coCourseId", coCourseId);
        CompanyCourse course = (CompanyCourse) query.uniqueResult();

        if (course == null) {
            logger.info("company course NOT found for companyID::" + companyId
                    + " and cocourseId:: " +  coCourseId);
        }

        return course;
    }

    @Override
    public void save(CompanyCourse companyCourse) {
        getCurrentSession().save(companyCourse);
        logger.info("company course created::" , companyCourse);
    }
}
