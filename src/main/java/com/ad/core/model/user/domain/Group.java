package com.ad.core.model.user.domain;

import com.ad.core.model.company.domain.Company;

import javax.persistence.*;

/**
 * Created by mnavarro on 04/11/2014.
 */
@Entity
@Table(name = "UserGroup")
public class Group
{
    @Id
    @GeneratedValue
    @Column(name = "UserGroupID")
    private Integer userGroupId;

    @Column(name = "ParentID")
    private Integer parentId;

    @Column(name = "LanguageTypeID")
    private Integer languageTypeId;

    @Column(name = "ShortDescription")
    private String shortDescription;

    @Column(name = "LongDescription")
    private String longDescription;

    @ManyToOne
    @JoinColumn(name = "CompanyID")
    private Company company;

    public Integer getUserGroupId() {
        return userGroupId;
    }

    public Group setUserGroupId(Integer userGroupId) {
        this.userGroupId = userGroupId;
        return this;
    }

    public Integer getParentId() {
        return parentId;
    }

    public Group setParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

    public Integer getLanguageTypeId() {
        return languageTypeId;
    }

    public Group setLanguageTypeId(Integer languageTypeId) {
        this.languageTypeId = languageTypeId;
        return this;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public Group setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public Group setLongDescription(String longDescription) {
        this.longDescription = longDescription;
        return this;
    }

    public Company getCompany() {
        return company;
    }

    public Group setCompany(Company company) {
        this.company = company;
        return this;
    }

    @Override
    public String toString() {
        return "Group{" +
                "userGroup=" + userGroupId +
                ", parentId=" + parentId +
                ", languageTypeId=" + languageTypeId +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", companyId=" + getCompany().getId() +
                '}';
    }
}
