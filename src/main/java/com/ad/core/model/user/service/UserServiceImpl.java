package com.ad.core.model.user.service;

import com.ad.core.model.user.dao.UserDao;
import com.ad.core.model.user.domain.User;
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

	public User getUserById(Integer id) {
		return userDao.findById(id);
	}


    @Transactional
    public void saveUser(User user) {
        userDao.insert(user);
        System.out.println("after save in service : user id's = " + user.getId());
        user.setFirstName("raviya");
        userDao.update(user);
    }

}
