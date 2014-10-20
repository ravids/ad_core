package com.ad.core.dao.sql.user.fixture;

import com.ad.core.model.user.domain.User;

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
