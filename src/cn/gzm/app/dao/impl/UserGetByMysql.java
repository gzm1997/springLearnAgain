package cn.gzm.app.dao.impl;

import cn.gzm.app.dao.UserDao;

/**
 * @author: gzm
 * @date: 19-6-4
 * @description: Pass
 */
public class UserGetByMysql implements UserDao {
    public UserGetByMysql() {
        System.out.println("创建UserGetByMysql");
    }
    @Override
    public void getUser() {
        System.out.println("通过mysql获取用户数据");
    }
}
