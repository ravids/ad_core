package com.ad.core.model.company.domain;

import javax.persistence.*;

/**
 * Domain entity.
 * 
 * @author RD
 */
@Entity
@Table(name = "Company")
public class Company {
    @Id
    @GeneratedValue
    @Column(name = "CompanyID")
	private Integer id;
    @Column(name = "CompanyName")
	private String name;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("company [id=").append(id).append(", name=").append(name).append("]");
		return builder.toString();
	}

}
