package com.ad.core.model.company.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mnavarro on 05/11/2014.
 */
@Entity
@IdClass(CompanyLessonPK.class)
@Table(name = "CompanyLesson")
public class CompanyLesson implements Serializable
{
    @Id
    @Column(name = "CompanyID")
    private Integer companyId;

    @Id
    @Column(name = "CourseID")
    private Integer courseId;

    @Id
    @Column(name = "CoCourseID")
    private Integer coCourseId;

    @Id
    @Column(name = "LessonID")
    private Integer lessonId;

    @Column(name = "TotalCategory1")
    private Integer totalCategory1;

    @Column(name = "TotalCategory2")
    private Integer totalCategory2;

    @Column(name = "TotalQuestions")
    private Integer totalQuestions;

    public Integer getCompanyId() {
        return companyId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public Integer getCoCourseId() {
        return coCourseId;
    }

    public Integer getLessonId() {
        return lessonId;
    }

    public Integer getTotalCategory1() {
        return totalCategory1;
    }

    public Integer getTotalCategory2() {
        return totalCategory2;
    }

    public Integer getTotalQuestions() {
        return totalQuestions;
    }

    public CompanyLesson setCompanyId(final Integer companyId) {
        this.companyId = companyId;
        return this;
    }

    public CompanyLesson setCourseId(final Integer courseId) {
        this.courseId = courseId;
        return this;
    }

    public CompanyLesson setCoCourseId(final Integer coCourseId) {
        this.coCourseId = coCourseId;
        return this;
    }

    public CompanyLesson setLessonId(final Integer lessonId) {
        this.lessonId = lessonId;
        return this;
    }

    public CompanyLesson setTotalCategory1(final Integer totalCategory1) {
        this.totalCategory1 = totalCategory1;
        return this;
    }

    public CompanyLesson setTotalCategory2(final Integer totalCategory2) {
        this.totalCategory2 = totalCategory2;
        return this;
    }

    public CompanyLesson setTotalQuestions(final Integer totalQuestions) {
        this.totalQuestions = totalQuestions;
        return this;
    }
}
