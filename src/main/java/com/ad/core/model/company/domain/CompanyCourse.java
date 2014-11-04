package com.ad.core.model.company.domain;

import javax.persistence.*;

/**
 * Created by sabrishamkar on 11/4/14.
 */
@Entity
@Table(name = "CompanyCourse")
public class CompanyCourse {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "CompanyID")
    private int CompanyId;
    @Column(name = "CourseID")
    private int CourseId;
    @Column(name = "CoCourseID")
    private int CoCourseId;
    @Column(name = "CoCourseName")
    private String CoCourseName;

    public Integer getId() {
        return id;
    }

    public CompanyCourse setId(Integer id) {
        this.id = id;
        return this;
    }

    public int getCompanyId() {
        return CompanyId;
    }

    public CompanyCourse setCompanyId(int companyId) {
        CompanyId = companyId;
        return this;
    }

    public int getCourseId() {
        return CourseId;
    }

    public CompanyCourse setCourseId(int courseId) {
        CourseId = courseId;
        return this;
    }

    public int getCoCourseId() {
        return CoCourseId;
    }

    public CompanyCourse setCoCourseId(int coCourseId) {
        CoCourseId = coCourseId;
        return this;
    }

    public String getCoCourseName() {
        return CoCourseName;
    }

    public CompanyCourse setCoCourseName(String coCourseName) {
        CoCourseName = coCourseName;
        return this;
    }

    @Override
    public String toString() {
        return "CompanyCourse{" +
                "id=" + id +
                ", CompanyId=" + CompanyId +
                ", CourseId=" + CourseId +
                ", CoCourseId=" + CoCourseId +
                ", CoCourseName='" + CoCourseName + '\'' +
                '}';
    }
}
