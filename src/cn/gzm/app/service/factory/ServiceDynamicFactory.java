package cn.gzm.app.service.factory;

import cn.gzm.app.dao.UserDao;
import cn.gzm.app.service.impl.UserDataServiceImpl;

/**
 * @author: gzm
 * @date: 19-6-5
 * @description: Pass
 */
public class ServiceDynamicFactory {
    public UserDataServiceImpl newInstance(UserDao userDao) {
        System.out.println("使用动态工厂方法创建对象");
        return new UserDataServiceImpl(userDao);
    }
}
