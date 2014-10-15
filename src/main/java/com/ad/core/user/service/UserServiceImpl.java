package com.ad.core.user.service;

import com.ad.core.user.dao.PersonDao;
import com.ad.core.user.dao.UserDao;
import com.ad.core.user.domain.Person;
import com.ad.core.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

	private UserDao personDao;

	@Autowired
	public UserServiceImpl(UserDao personDao) {
		super();
		this.personDao = personDao;
	}

	public User getPersonById(Integer id) {
		return personDao.findById(id);
	}



}
