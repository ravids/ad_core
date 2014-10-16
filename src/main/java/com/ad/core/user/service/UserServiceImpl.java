package com.ad.core.user.service;

import com.ad.core.user.dao.UserDao;
import com.ad.core.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	@Autowired
	public UserServiceImpl(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	public User getuserById(Integer id) {
		return userDao.findById(id);
	}


    @Transactional
    public void saveUser(User user) {
        userDao.insert(user);
        System.out.println("after save in service : user id's = " + user.getId());
    }

}
