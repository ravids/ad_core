package com.ad.core.dao.sql.user.fixture;

import com.ad.core.model.company.domain.Company;
import com.ad.core.model.user.dao.GroupCourseDao;
import com.ad.core.model.user.domain.Group;
import com.ad.core.model.user.domain.GroupCourse;
import com.ad.core.model.user.domain.GroupLesson;
import com.ad.core.model.user.domain.User;

/**
 * Test fixture for unit tests.
 * 
 * @author RD
 */
public class DaoImplTestFixture {

    /**
     * Creates a user with id=1
     * @return
     */
    public User createUser() {
        User user = new User();
        user.setId(1);
        user.setUserName("ravi123");
        user.setFirstName("ravi");
        user.setLastName("silva");
        return user;
    }

    public Group createGroup() {

        Group group = new Group();
        group.setCompany(createCompany())
                .setLanguageTypeId(1)
                .setLongDescription("Long Group")
                .setShortDescription("Short Group")
                .setParentId(-1)
        ;

        return group;
    }

    public GroupCourse createGroupCourse() {

        GroupCourse groupCourse = new GroupCourse();
        groupCourse.setCoCourseId(1)
            .setUserGroupId(1)
            .setFrequency("Weekly")
            .setPassmark(50)
        ;

        return groupCourse;
    }

    public GroupLesson createGroupLesson() {

        GroupLesson groupLesson = new GroupLesson();
        groupLesson.setCoCourseId(1)
            .setCoCourseId(1)
            .setUserGroupId(1)
            .setLanguageTypeId(1)
            .setFrequency("Weekly")
            .setStartDate("2014-11-03")
        ;

        return groupLesson;
    }

    public Company createCompany() {
        Company company = new Company();
        company.setId(410)
        ;

        return company;
    }


}
