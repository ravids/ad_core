package com.ad.core.dao.sql.lesson;

import com.ad.core.model.lesson.dao.LessonDao;
import com.ad.core.model.lesson.domain.Lesson;
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

import static org.junit.Assert.assertTrue;

/**
 * Created by mnavarro on 05/11/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DaoTestConfig.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
public class TestLessonDaoImpl {

    @Autowired
    private LessonDao lessonDao;

    @Test
    public void test_findByCourseIdAndLessonCode() {
        Lesson lesson = lessonDao.findByCourseIdAndLessonCode(3, "ABC");
        assertTrue(lesson.getLanguageTypeId().equals(1));
    }
}
