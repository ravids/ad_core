package com.ad.core.user.dao;

import com.ad.core.user.dao.fixture.DaoImplTestFixture;
import com.ad.core.user.springconfig.DaoTestConfig;
import com.ad.core.user.domain.Person;
import com.ad.core.user.exception.PersonNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;


import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DaoTestConfig.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
public class TestPersonDaoImpl {

	@Autowired private PersonDaoImpl personDao;

//    @Before
//    @DatabaseSetup("personData.xml")
//    @DbUnitConfiguration(databaseConnection="dataSource")
//    @DbUnitConfiguration(dbUnitExecutions = {
//            @DbUnitExecution(datasets = {"/personData.xml" }, dataSource = "dataSource") })
    public void setup() {

    }

	@Test
	public void test_findById() {
		Integer id = 1;
		Person p1 = personDao.findById(id);
		assertEquals(p1.getId(), id);
	}

	@Test(expected = PersonNotFoundException.class)
	public void test_findById_NotFound() {
		Integer id = -1;
		personDao.findById(id);
	}
	
	@Test
	public void test_insert() {
		DaoImplTestFixture f = new DaoImplTestFixture();
		Person person = f.createPerson();
		
		// function not supported!? the generated key stuff...
		personDao.insert(person);
	}
	
	@Test
	public void test_update() {
		DaoImplTestFixture f = new DaoImplTestFixture();
		Person person = f.createPerson();
		
		String newFirstName = "Fred";
		
		person.setFirstName(newFirstName);
		personDao.update(person);
		
		Person updatedPerson = personDao.findById(person.getId());
		assertEquals(newFirstName, updatedPerson.getFirstName());
	}

}
