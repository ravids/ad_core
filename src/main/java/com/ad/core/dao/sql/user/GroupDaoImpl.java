package com.ad.core.dao.sql.user;

import com.ad.core.model.user.dao.GroupDao;
import com.ad.core.model.user.domain.Group;
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
 * Created by mnavarro on 04/11/2014.
 */
@Repository
public class GroupDaoImpl implements GroupDao
{

    private static final Logger logger = LoggerFactory.getLogger(WebApplicationInitializer.class);

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
    public void insert(Group group) {
        getCurrentSession().save(group);
        logger.info("after save in dao : group id's = " + group.getUserGroupId(), group);
    }
}
