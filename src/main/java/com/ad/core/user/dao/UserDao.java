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

}