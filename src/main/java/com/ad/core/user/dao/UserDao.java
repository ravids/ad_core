package com.ad.core.user.dao;

import com.ad.core.user.domain.User;

/**
 * DAO for user database table.
 * 
 * @author RD
 */
public interface UserDao {

	/**
	 * Selects the user record with the given id.
	 * @param id
	 * @return Returns the user for the given id. Returns null if none found.
	 */
    User findById(Integer id);

    /**
     * Inserts a user record using the non-id properties.
     * The id property is populated with the generated id.
     * @param user
     */
    void insert(User user);

    /**
     * Updates the user record with p.getId().
     * @param p
     */
    void update(User p);
}