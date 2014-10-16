package com.ad.core.user.dao;

import com.ad.core.user.dao.fixture.DaoImplTestFixture;
import com.ad.core.user.domain.Person;
import com.ad.core.user.domain.User;
import com.ad.core.user.exception.PersonNotFoundException;
import com.ad.core.user.springconfig.DaoTestConfig;
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
        User person = f.createUser();

        // function not supported!? the generated key stuff...
        userDao.insert(person);
        Integer id = 4;
        assertEquals(person.getId(), id);
    }


}
