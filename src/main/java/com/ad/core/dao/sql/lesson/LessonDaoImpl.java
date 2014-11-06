package com.ad.core.dao.sql.lesson;

import com.ad.core.model.lesson.dao.LessonDao;
import com.ad.core.model.lesson.domain.Lesson;
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

/**
 * Created by mnavarro on 05/11/2014.
 */
@Repository
public class LessonDaoImpl implements LessonDao {

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
    public Lesson findByCourseIdAndLessonCode(Integer courseId, String lessonCode) {
        String hsql = "from Lesson "
                + " where courseId = :courseId"
                + " and lessonCode = :lessonCode";
        Query query = getCurrentSession()
                .createQuery(hsql)
                .setParameter("courseId", courseId)
                .setParameter("lessonCode", lessonCode);
        Lesson lesson = (Lesson) query.uniqueResult();
        if (lesson == null)
            logger.info("category lesson NOT found for courseId: " + courseId + "and lessonCode:: " + lessonCode);
        return lesson;
    }
}
