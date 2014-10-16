package com.ad.core.user.service.fixture;

import com.ad.core.user.domain.User;

/**
 * Test fixture for unit tests.
 * 
 * @author RD
 */
public class ServiceTestFixture {

    /**
     * Creates a user with id=1
     * @return
     */
    public User createUser() {
        User user = new User();
        user.setId(1);
        user.setUserName("sil234");
        user.setFirstName("rd");
        user.setLastName("sul");
        return user;
    }

}
