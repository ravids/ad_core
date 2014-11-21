package com.ad.core.dao.sql.company.fixture;

import com.ad.core.model.company.domain.Company;
import com.ad.core.model.company.domain.CompanyLesson;

/**
 * Created by mnavarro on 05/11/2014.
 */
public class DaoImplTestFixture {

    public Company createCompany() {
        Company company = new Company();
        company.setId(410);

        return company;
    }

    public CompanyLesson createLesson() {
        CompanyLesson lesson = new CompanyLesson();
        lesson.setCompanyId(410)
            .setCoCourseId(1)
            .setCourseId(1)
            .setLessonId(1)
            .setTotalCategory1(1)
            .setTotalCategory2(1)
            .setTotalQuestions(2)
        ;

        return lesson;
    }
}
