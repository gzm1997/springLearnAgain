package cn.gzm.app.service.impl;

import cn.gzm.app.dao.UserDao;
import cn.gzm.app.service.UserDataService;

/**
 * @author: gzm
 * @date: 19-6-4
 * @description: Pass
 */
public class UserDataServiceImpl implements UserDataService {
    private UserDao userDao = null;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
