package com.ad.core.user.service;

import com.ad.core.user.dao.PersonDao;
import com.ad.core.user.dao.UserDao;
import com.ad.core.user.domain.Person;
import com.ad.core.user.domain.User;
import com.ad.core.user.service.fixture.ServiceTestFixture;
import com.ad.core.user.springconfig.ServiceTestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ServiceTestConfig.class })
public class TestUserServiceImpl {

	@Autowired private UserService personService;
	@Autowired private UserDao mockPersonDao;

	@Test
	public void test_getPersonById() {
		ServiceTestFixture f = new ServiceTestFixture();
		User personExists = f.createUser();

		when(mockPersonDao.findById(anyInt())).thenReturn(personExists);

		User personFound = personService.getPersonById(personExists.getId());

		assertEquals(personExists.getId(), personFound.getId());
		assertEquals(personExists, personFound);
	}


    @Test
    public void test_savePerson() {
        ServiceTestFixture f = new ServiceTestFixture();
        User personExists = f.createUser();
        personExists.setId(null);

        final Holder invokeCounter = new Holder(); // since we can't use verify() on void method
        doAnswer(new Answer<Object>() {
            public Object answer(InvocationOnMock invocation) throws Throwable {
                invokeCounter.value = invokeCounter.value + 1;
                return null;
            }
        }).when(mockPersonDao).insert((User) anyObject());

        personService.saveUser(personExists);

        assertEquals(1, invokeCounter.value);
    }

	private class Holder {
		public int value = 0;
	}

}
