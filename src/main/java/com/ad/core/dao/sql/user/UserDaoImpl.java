package com.ad.core.dao.sql.user;

import com.ad.core.model.user.dao.UserDao;
import com.ad.core.model.user.domain.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.WebApplicationInitializer;

@Repository
public class UserDaoImpl implements UserDao {

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


	public User findById(Integer id) {
        return (User) getCurrentSession().get(User.class, id);
	}

    public void insert(User user) {
        getCurrentSession().save(user);
        System.out.println("after save in dao : user id's = " + user.getId());
    }

    public void update(User user) {
        getCurrentSession().save(user);
    }

}
