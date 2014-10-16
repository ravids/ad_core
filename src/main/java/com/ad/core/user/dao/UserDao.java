package com.ad.core.user.dao;

import com.ad.core.user.domain.Person;
import com.ad.core.user.domain.User;

/**
 * DAO for person database table.
 * 
 * @author RD
 */
public interface UserDao {

	/**
	 * Selects the person record with the given id.
	 * @param id
	 * @return Returns the Person for the given id. Returns null if none found.
	 */
    User findById(Integer id);

    /**
     * Inserts a person record using the non-id properties.
     * The id property is populated with the generated id.
     * @param person
     */
    void insert(User person);

    /**
     * Updates the person record with p.getId().
     * @param p
     */
    void update(User p);
}