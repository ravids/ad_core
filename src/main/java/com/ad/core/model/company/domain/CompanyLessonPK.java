package com.ad.core.model.company.domain;

import java.io.Serializable;

/**
 * Created by mnavarro on 05/11/2014.
 */
public class CompanyLessonPK implements Serializable
{
    protected Integer companyId;
    protected Integer courseId;
    protected Integer coCourseId;
    protected Integer lessonId;

    public CompanyLessonPK() {}

    public CompanyLessonPK(Integer companyId, Integer courseId, Integer coCourseId, Integer lessonId) {
        this.companyId = companyId;
        this.courseId = courseId;
        this.coCourseId = coCourseId;
        this.lessonId = lessonId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompanyLessonPK)) return false;

        CompanyLessonPK lessonPK = (CompanyLessonPK) o;

        if (!coCourseId.equals(lessonPK.coCourseId)) return false;
        if (!companyId.equals(lessonPK.companyId)) return false;
        if (!courseId.equals(lessonPK.courseId)) return false;
        if (!lessonId.equals(lessonPK.lessonId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = companyId.hashCode();
        result = 31 * result + courseId.hashCode();
        result = 31 * result + coCourseId.hashCode();
        result = 31 * result + lessonId.hashCode();
        return result;
    }
}
