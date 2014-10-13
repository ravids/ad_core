package com.ad.core.user.dao.fixture;

import com.ad.core.user.domain.Person;

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

}
