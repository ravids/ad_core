package com.ad.core.model.user.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mnavarro on 05/11/2014.
 */
@Entity
@IdClass(GroupLessonPK.class)
@Table(name = "UserGroupLesson")
public class GroupLesson implements Serializable {

    @Id
    @Column(name = "LessonID")
    private Integer lessonId;

    @Column(name = "CoCourseID")
    private Integer coCourseId;

    @Column(name = "UserGroupID")
    private Integer userGroupId;

    @Column(name = "LanguageTypeID")
    private Integer languageTypeId;

    @Column(name = "StartDate")
    private String startDate;

    @Column(name = "Frequency")
    private String frequency;

    public Integer getLessonId() {
        return lessonId;
    }

    public Integer getCoCourseId() {
        return coCourseId;
    }

    public Integer getUserGroupId() {
        return userGroupId;
    }

    public Integer getLanguageTypeId() {
        return languageTypeId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getFrequency() {
        return frequency;
    }

    public GroupLesson setLessonId(final Integer lessonId) {
        this.lessonId = lessonId;
        return this;
    }

    public GroupLesson setCoCourseId(final Integer coCourseId) {
        this.coCourseId = coCourseId;
        return this;
    }

    public GroupLesson setUserGroupId(final Integer userGroupId) {
        this.userGroupId = userGroupId;
        return this;
    }

    public GroupLesson setLanguageTypeId(final Integer languageTypeId) {
        this.languageTypeId = languageTypeId;
        return this;
    }

    public GroupLesson setStartDate(final String startDate) {
        this.startDate = startDate;
        return this;
    }

    public GroupLesson setFrequency(final String frequency) {
        this.frequency = frequency;
        return this;
    }
}
