package com.ad.core.model.user.domain;

import javax.persistence.*;

/**
 * Domain entity.
 * 
 * @author RD
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
	private Integer id;
    @Column(name = "user_name")
	private String userName;
    @Column(name = "first_name")
	private String firstName;
    @Column(name = "last_name")
	private String lastName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("user [id=").append(id).append(", userName=").append(userName).append(", firstName=")
				.append(firstName).append(", lastName=").append(lastName).append("]");
		return builder.toString();
	}

}
