package cn.gzm.app.dao.impl;

import cn.gzm.app.dao.UserDao;

/**
 * @author: gzm
 * @date: 19-6-4
 * @description: Pass
 */
public class UserGetByOracle implements UserDao {
    public UserGetByOracle() {
        System.out.println("创建UserGetByOracle");
    }
    @Override
    public void getUser() {
        System.out.println("通过oracle获取用户数据");
    }
}
