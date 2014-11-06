package com.ad.core.model.lesson.dao;

import com.ad.core.model.lesson.domain.Lesson;

/**
 * Created by mnavarro on 05/11/2014.
 */
public interface LessonDao
{
    Lesson findByCourseIdAndLessonCode(Integer courseId, String lessonCode);
}
