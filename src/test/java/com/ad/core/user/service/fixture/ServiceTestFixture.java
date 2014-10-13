package com.ad.core.user.service.fixture;

import com.ad.core.user.domain.Person;

/**
 * Test fixture for unit tests.
 * 
 * @author RD
 */
public class ServiceTestFixture {

	/**
	 * Creates a Person with id=1
	 * @return
	 */
	public Person createPerson() {
		Person person = new Person();
		person.setId(1);
		person.setUserName("sil234");
		person.setFirstName("rd");
		person.setLastName("sul");
		return person;
	}

}
