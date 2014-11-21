package com.ad.core.dao.sql.user;

import com.ad.core.model.user.dao.GroupLessonDao;
import com.ad.core.model.user.domain.GroupLesson;
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
public class GroupLessonDaoImpl implements GroupLessonDao{

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
    public void insert(GroupLesson groupLesson) {
        getCurrentSession().save(groupLesson);
        logger.info("after save in dao : group lesson pk = "
                + groupLesson.getUserGroupId()
                + "-" + groupLesson.getCoCourseId()
                + "-" + groupLesson.getLessonId()
                + "-" + groupLesson.getLanguageTypeId(), groupLesson);
    }
}
