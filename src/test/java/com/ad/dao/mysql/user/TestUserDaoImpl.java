package com.ad.dao.mysql.user;

import com.ad.dao.mysql.user.fixture.DaoImplTestFixture;
import com.ad.core.user.domain.User;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.ad.core.dao.mysql.user.UserDaoImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DaoTestConfig.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
public class TestUserDaoImpl {

	@Autowired private UserDaoImpl userDao;

	@Test
	public void test_findById() {
		Integer id = 1;
		User p1 = userDao.findById(id);
		assertEquals(p1.getId(), id);
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
        Integer id = 4;
        assertEquals(user.getId(), id);
    }


}
