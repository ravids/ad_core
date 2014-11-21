package com.ad.core.dao.sql.company;

import com.ad.core.dao.sql.company.fixture.DaoImplTestFixture;
import com.ad.core.model.company.dao.CompanyLessonDao;
import com.ad.core.model.company.domain.CompanyLesson;
import com.ad.dao.mysql.springconfig.DaoTestConfig;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

/**
 * Created by mnavarro on 05/11/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DaoTestConfig.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
public class TestCompanyLessonDaoImpl {

    @Autowired
    private CompanyLessonDao lessonDao;

    @Test
    public void test_save() {
        DaoImplTestFixture f = new DaoImplTestFixture();
        CompanyLesson lesson = f.createLesson();

        lessonDao.save(lesson);
    }

}
