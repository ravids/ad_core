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


	public User findById(Integer id) {
        return (User) getCurrentSession().get(User.class, id);
	}

    public void insert(User person) {
        getCurrentSession().save(person);
        System.out.println("after save in dao : user id's = " + person.getId());
    }

    public void update(User person) {
        int numRowsAffected = jdbcTemplate.update(
                "update person set user_name = :userName, first_name = :firstName, last_name = :lastName where id = :id",
                new BeanPropertySqlParameterSource(person));

        if (numRowsAffected == 0) {
            throw new PersonNotFoundException("No person found for id: " + person.getId());
        }
    }

    private static class PersonRowMapper implements RowMapper<Person> {
        public Person mapRow(ResultSet res, int rowNum) throws SQLException {
            Person p = new Person();
            p.setId(res.getInt("id"));
            p.setUserName(res.getString("user_name"));
            p.setFirstName(res.getString("first_name"));
            p.setLastName(res.getString("last_name"));
            return p;
        }
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
