package com.ad.core.dao.sql.company;

import com.ad.core.dao.sql.user.fixture.DaoImplTestFixture;
import com.ad.core.model.company.dao.CompanyCourseDao;
import com.ad.core.model.company.domain.CompanyCourse;
import com.ad.core.model.user.domain.User;
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

import static org.junit.Assert.assertEquals;

/**
 * Created by sabrishamkar on 11/4/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DaoTestConfig.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
public class TestCompanyCourseDaoImpl {


    @Autowired
    CompanyCourseDao companyCourseDao;

    @Test
    public void test_save() {
//        DaoImplTestFixture f = new DaoImplTestFixture();
//        User user = f.createUser();

        CompanyCourse companyCourse = new CompanyCourse();
        companyCourse.setCoCourseId(12)
                .setCoCourseName("coCourseName")
                .setCompanyId(1231);

//        companyCourseDao.save(companyCourse);
   //     Integer id = 1;
    //    assertEquals(user.getId(), id);
    }

}
