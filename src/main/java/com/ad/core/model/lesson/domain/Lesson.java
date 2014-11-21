package com.ad.core.model.lesson.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mnavarro on 05/11/2014.
 */
@Entity
@IdClass(LessonPK.class)
@Table(name = "Lesson",
        uniqueConstraints = @UniqueConstraint(columnNames = {"CourseID", "LessonID", "LanguageTypeID"}))
public class Lesson implements Serializable{

    @Id
    @Column(name = "CourseID")
    private Integer courseId;

    @Id
    @Column(name = "LessonID")
    private Integer lessonId;

    @Id
    @Column(name = "LanguageTypeID")
    private Integer languageTypeId;

    @Column(name = "LessonTypeID")
    private Integer lessonTypeId;

    @Column(name = "LessonCode")
    private String lessonCode;

    public Integer getCourseId() {
        return courseId;
    }

    public Integer getLessonId() {
        return lessonId;
    }

    public Integer getLanguageTypeId() {
        return languageTypeId;
    }

    public Integer getLessonTypeId() {
        return lessonTypeId;
    }

    public String getLessonCode() {
        return lessonCode;
    }

    public Lesson setCourseId(final Integer courseId) {
        this.courseId = courseId;
        return this;
    }

    public Lesson setLessonId(final Integer lessonId) {
        this.lessonId = lessonId;
        return this;
    }

    public Lesson setLanguageTypeId(final Integer languageTypeId) {
        this.languageTypeId = languageTypeId;
        return this;
    }

    public Lesson setLessonTypeId(final Integer lessonTypeId) {
        this.lessonTypeId = lessonTypeId;
        return this;
    }

    public Lesson setLessonCode(final String lessonCode) {
        this.lessonCode = lessonCode;
        return this;
    }
}
