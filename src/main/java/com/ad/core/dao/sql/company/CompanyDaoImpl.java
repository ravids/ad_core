package com.ad.core.dao.sql.company;

import com.ad.core.model.company.dao.CompanyDao;
import com.ad.core.model.company.domain.Company;
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
public class CompanyDaoImpl implements CompanyDao {

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


	public Company findById(Integer id) {
        return (Company) getCurrentSession().get(Company.class, id);
	}

    public void insert(Company company) {
        getCurrentSession().save(company);
        System.out.println("after save in dao : company id's = " + company.getId());
    }

    public void update(Company company) {
        getCurrentSession().save(company);
    }

}
