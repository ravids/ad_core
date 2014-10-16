package com.ad.core.user.service;

import com.ad.core.user.dao.UserDao;
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

	@Autowired private UserService userService;
	@Autowired private UserDao mockuserDao;

	@Test
	public void test_getuserById() {
		ServiceTestFixture f = new ServiceTestFixture();
		User userExists = f.createUser();

		when(mockuserDao.findById(anyInt())).thenReturn(userExists);

		User userFound = userService.getuserById(userExists.getId());

		assertEquals(userExists.getId(), userFound.getId());
		assertEquals(userExists, userFound);
	}


    @Test
    public void test_saveuser() {
        ServiceTestFixture f = new ServiceTestFixture();
        User userExists = f.createUser();
        userExists.setId(null);

        final Holder invokeCounter = new Holder(); // since we can't use verify() on void method
        doAnswer(new Answer<Object>() {
            public Object answer(InvocationOnMock invocation) throws Throwable {
                invokeCounter.value = invokeCounter.value + 1;
                return null;
            }
        }).when(mockuserDao).insert((User) anyObject());

        userService.saveUser(userExists);

        assertEquals(1, invokeCounter.value);
    }

	private class Holder {
		public int value = 0;
	}

}
