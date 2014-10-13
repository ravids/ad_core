package com.ad.core.user.util;

import com.ad.core.user.domain.Person;
import com.ad.core.user.dto.PersonDto;
import org.springframework.stereotype.Component;

/**
 * Factory methods for creating DTOs.
 * 
 * @author RD
 */
@Component
public class DtoFactory {

	/**
	 * Converts a domain entity to a dto.
	 * @param domain
	 * @return
	 */
	public PersonDto createPerson(Person domain) {
		// TODO convert to dozer
		PersonDto dto = new PersonDto();
		dto.setId(domain.getId());
		dto.setFullname(domain.getFirstName() + " " + domain.getLastName());
		return dto;
	}

}
