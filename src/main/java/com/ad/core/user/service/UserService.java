package com.ad.core.user.service;

import com.ad.core.user.domain.User;

/**
 * Service for managing people.
 * 
 * @author RD
 */
public interface UserService {

	/**
	 * @param id
	 * @return Returns the user with the given id.
	 */
	public User getuserById(Integer id);

    /**
     * Creates a new user and populates the <code>id</code> property with the generated id.
     * @param user All non-id properties are used to create the new user.
     */
    public void saveUser(User user);
}
