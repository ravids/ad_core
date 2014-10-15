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


}
