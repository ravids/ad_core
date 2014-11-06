package com.ad.core.model.base.domain;

import java.io.Serializable;

/**
 * Created by mnavarro on 05/11/2014.
 */
public class LessonPK implements Serializable {

    private Integer courseId;
    private Integer lessonId;
    private Integer languageTypeId;

    public LessonPK() {}

    public LessonPK(Integer courseId, Integer lessonId, Integer languageTypeId) {
        this.courseId = courseId;
        this.lessonId = lessonId;
        this.languageTypeId = languageTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LessonPK)) return false;

        LessonPK lessonPK = (LessonPK) o;

        if (!courseId.equals(lessonPK.courseId)) return false;
        if (!languageTypeId.equals(lessonPK.languageTypeId)) return false;
        if (!lessonId.equals(lessonPK.lessonId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = courseId.hashCode();
        result = 31 * result + lessonId.hashCode();
        result = 31 * result + languageTypeId.hashCode();
        return result;
    }
}
