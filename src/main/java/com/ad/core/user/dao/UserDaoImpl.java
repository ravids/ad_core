package com.ad.core.user.dao;

import com.ad.core.user.domain.Person;
import com.ad.core.user.domain.User;
import com.ad.core.user.exception.PersonNotFoundException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.WebApplicationInitializer;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

//	@Autowired
//	public UserDaoImpl(DataSource dataSource) {
//		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
//	}

	public User findById(Integer id) {
        return (User) getCurrentSession().get(User.class, id);

//        Map<String, Object> params = new HashMap<String, Object>();
//		params.put("id", id);
//
//		List<User> list = jdbcTemplate.query("select * from person where id = :id", params, new UserRowMapper());
//		if (list.isEmpty()) {
//			throw new PersonNotFoundException("No person found for id: " + id);
//		} else {
//			return list.get(0);
//		}
	}


	private static class UserRowMapper implements RowMapper<User> {
		public User mapRow(ResultSet res, int rowNum) throws SQLException {
            User p = new User();
			p.setId(res.getInt("id"));
			p.setUserName(res.getString("user_name"));
			p.setFirstName(res.getString("first_name"));
			p.setLastName(res.getString("last_name"));
			return p;
		}
	}

}
