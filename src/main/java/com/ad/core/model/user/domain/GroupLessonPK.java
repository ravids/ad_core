package com.ad.core.model.user.domain;

import java.io.Serializable;

/**
 * Created by mnavarro on 05/11/2014.
 */
public class GroupLessonPK implements Serializable {

    protected Integer lessonId;
    protected Integer coCourseId;
    protected Integer userGroupId;
    protected Integer languageTypeId;

    public GroupLessonPK() {}

    public GroupLessonPK(Integer lessonId, Integer coCourseId, Integer userGroupId, Integer languageTypeId) {
        this.languageTypeId = languageTypeId;
        this.lessonId = lessonId;
        this.coCourseId = coCourseId;
        this.userGroupId = userGroupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupLessonPK)) return false;

        GroupLessonPK that = (GroupLessonPK) o;

        if (!coCourseId.equals(that.coCourseId)) return false;
        if (!languageTypeId.equals(that.languageTypeId)) return false;
        if (!lessonId.equals(that.lessonId)) return false;
        if (!userGroupId.equals(that.userGroupId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lessonId.hashCode();
        result = 31 * result + coCourseId.hashCode();
        result = 31 * result + userGroupId.hashCode();
        result = 31 * result + languageTypeId.hashCode();
        return result;
    }
}
