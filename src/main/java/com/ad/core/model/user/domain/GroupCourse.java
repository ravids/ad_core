package com.ad.core.model.user.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mnavarro on 05/11/2014.
 */
@Entity
@IdClass(GroupCoursePK.class)
@Table(name = "UserGroupCourse")
public class GroupCourse implements Serializable
{
    @Id
    @Column(name = "UserGroupID")
    private Integer userGroupId;

    @Id
    @Column(name = "CoCourseID")
    private Integer coCourseId;

    @Column(name = "Passmark")
    private Integer passmark;

    @Column(name = "Frequency")
    private String frequency;

    public Integer getUserGroupId() {
        return userGroupId;
    }

    public Integer getCoCourseId() {
        return coCourseId;
    }

    public Integer getPassmark() {
        return passmark;
    }

    public String getFrequency() {
        return frequency;
    }

    public GroupCourse setUserGroupId(final Integer userGroupId) {
        this.userGroupId = userGroupId;
        return this;
    }

    public GroupCourse setCoCourseId(final Integer coCourseId) {
        this.coCourseId = coCourseId;
        return this;
    }

    public GroupCourse setPassmark(final Integer passmark) {
        this.passmark = passmark;
        return this;
    }

    public GroupCourse setFrequency(final String frequency) {
        this.frequency = frequency;
        return this;
    }
}
