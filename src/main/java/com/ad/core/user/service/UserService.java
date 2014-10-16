package com.ad.core.user.service;

import com.ad.core.user.domain.Person;
import com.ad.core.user.domain.User;

/**
 * Service for managing people.
 * 
 * @author RD
 */
public interface UserService {

	/**
	 * @param id
	 * @return Returns the person with the given id.
	 */
	public User getPersonById(Integer id);

    /**
     * Creates a new Person and populates the <code>id</code> property with the generated id.
     * @param person All non-id properties are used to create the new person.
     */
    public void saveUser(User person);
}
