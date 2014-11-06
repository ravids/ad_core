package com.ad.core.dao.sql.user;

import com.ad.core.dao.sql.user.fixture.DaoImplTestFixture;
import com.ad.core.model.user.domain.Group;
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
 * Created by mnavarro on 05/11/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DaoTestConfig.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
public class TestGroupDaoImpl {

    @Autowired
    private GroupDaoImpl groupDao;

    @Test
    public void test_insert() {
        DaoImplTestFixture f = new DaoImplTestFixture();
        Group group = f.createGroup();

        groupDao.insert(group);
        Integer id = 1;
        assertEquals(group.getUserGroupId(), id);
    }
}
