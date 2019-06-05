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

    public UserDataServiceImpl() {
        System.out.println("这是UserDataServiceImpl无参构造函数");
    }
    public UserDataServiceImpl(UserDao userDao) {
        System.out.println("这是UserDataServiceImpl有参构造函数");
        this.userDao = userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
