package com.ad.core.model.company.service;

import com.ad.core.model.company.domain.Company;

/**
 * Service for managing people.
 * 
 * @author RD
 */
public interface CompanyService {

	/**
	 * @param id
	 * @return Returns the user with the given id.
	 */
	public Company getCompanyById(Integer id);

    /**
     * Creates a new user and populates the <code>id</code> property with the generated id.
     * @param user All non-id properties are used to create the new user.
     */
    public void saveCompany(Company company);
}
