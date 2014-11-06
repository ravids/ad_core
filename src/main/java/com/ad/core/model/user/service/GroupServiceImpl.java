package com.ad.core.model.user.service;

import com.ad.core.model.user.dao.GroupDao;
import com.ad.core.model.user.domain.Group;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by mnavarro on 04/11/2014.
 */
public class GroupServiceImpl implements GroupService
{
    @Autowired
    private GroupDao groupDao;

    @Override
    public void saveGroup(Group group) {
        groupDao.insert(group);
    }
}
