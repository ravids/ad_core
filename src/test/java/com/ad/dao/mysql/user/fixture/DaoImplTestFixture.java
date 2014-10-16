package com.ad.dao.mysql.user.fixture;

import com.ad.core.user.domain.User;

/**
 * Test fixture for unit tests.
 * 
 * @author RD
 */
public class DaoImplTestFixture {

    /**
     * Creates a user with id=1
     * @return
     */
    public User createUser() {
        User user = new User();
        user.setId(1);
        user.setUserName("ravi123");
        user.setFirstName("ravi");
        user.setLastName("silva");
        return user;
    }

}
