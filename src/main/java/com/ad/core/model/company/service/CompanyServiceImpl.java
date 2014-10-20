package com.ad.core.model.company.service;

import com.ad.core.model.company.dao.CompanyDao;
import com.ad.core.model.company.domain.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompanyServiceImpl implements CompanyService {

	private CompanyDao companyDao;

	@Autowired
	public CompanyServiceImpl(CompanyDao companyDao) {
		super();
		this.companyDao = companyDao;
	}

	public Company getCompanyById(Integer id) {
		return companyDao.findById(id);
	}


    @Transactional
    public void saveCompany(Company company) {
        companyDao.insert(company);
        System.out.println("after save in service : user id's = " + company.getId());
    }

}
