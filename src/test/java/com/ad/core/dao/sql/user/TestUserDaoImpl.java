package com.ad.core.dao.sql.user;

import com.ad.core.dao.sql.user.fixture.DaoImplTestFixture;
import com.ad.core.model.user.dao.UserDao;
import com.ad.core.model.user.domain.User;
import com.ad.dao.mysql.springconfig.DaoTestConfig;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DaoTestConfig.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
@Transactional
public class TestUserDaoImpl {

	@Autowired private UserDao userDao;

	@Test
	public void test_findById() {
        DaoImplTestFixture f = new DaoImplTestFixture();
        User user = f.createUser();

        userDao.insert(user);

        Integer id = 1;
		User p1 = userDao.findById(id);
		assertEquals(p1.getId(), id);

        p1.setFirstName("raviyyaa");
        userDao.update(p1);

        User p2 = userDao.findById(id);
        assertEquals(p1.getFirstName(), "raviyyaa");
	}

    @Test
	public void test_findById_NotFound() {
		Integer id = -1;
        assertNull(userDao.findById(id));
	}

    @Test
    public void test_insert() {
        DaoImplTestFixture f = new DaoImplTestFixture();
        User user = f.createUser();

        userDao.insert(user);
        Integer id = 2;
        assertEquals(user.getId(), id);
    }


}
