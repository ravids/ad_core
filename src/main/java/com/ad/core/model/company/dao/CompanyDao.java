package com.ad.core.model.company.dao;

import com.ad.core.model.company.domain.Company;

/**
 * DAO for user database table.
 * 
 * @author RD
 */
public interface CompanyDao {

	/**
	 * Selects the user record with the given id.
	 * @param id
	 * @return Returns the user for the given id. Returns null if none found.
	 */
    Company findById(Integer id);

    /**
     * Inserts a user record using the non-id properties.
     * The id property is populated with the generated id.
     * @param user
     */
    void insert(Company user);

    /**
     * Updates the user record with p.getId().
     * @param p
     */
    void update(Company p);
}