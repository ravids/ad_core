package com.ad.core.model.company.dao;

import com.ad.core.model.company.domain.CompanyCourse;

/**
 * Created by sabrishamkar on 11/4/14.
 */
public interface CompanyCourseDao {

    CompanyCourse findByCompanyIdAndCoCourseId(Integer companyId, Integer coCourseId);

    void save (CompanyCourse companyCourse);
}
