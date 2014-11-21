package com.ad.core.model.user.domain;

import java.io.Serializable;

/**
 * Created by mnavarro on 05/11/2014.
 */
public class GroupCoursePK implements Serializable
{
    protected Integer userGroupId;
    protected Integer coCourseId;

    public GroupCoursePK(){}

    public GroupCoursePK(Integer userGroupId, Integer coCourseId) {
        this.userGroupId = userGroupId;
        this.coCourseId = coCourseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupCoursePK)) return false;

        GroupCoursePK that = (GroupCoursePK) o;

        if (!coCourseId.equals(that.coCourseId)) return false;
        if (!userGroupId.equals(that.userGroupId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userGroupId.hashCode();
        result = 31 * result + coCourseId.hashCode();
        return result;
    }
}
