package com.ad.dao.mysql.user.fixture;

import com.ad.core.user.domain.Person;
import com.ad.core.user.domain.User;

/**
 * Test fixture for unit tests.
 * 
 * @author RD
 */
public class DaoImplTestFixture {

	/**
	 * Creates a Person with id=1
	 * @return
	 */
	public Person createPerson() {
		Person person = new Person();
		person.setId(1);
		person.setUserName("ravi123");
		person.setFirstName("ravi");
		person.setLastName("silva");
		return person;
	}

    /**
     * Creates a Person with id=1
     * @return
     */
    public User createUser() {
        User person = new User();
        person.setId(1);
        person.setUserName("ravi123");
        person.setFirstName("ravi");
        person.setLastName("silva");
        return person;
    }

}
