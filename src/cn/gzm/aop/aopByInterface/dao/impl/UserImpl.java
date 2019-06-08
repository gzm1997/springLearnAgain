package cn.gzm.aop.aopByInterface.dao.impl;

import cn.gzm.aop.aopByInterface.dao.User;

/**
 * @author: gzm
 * @date: 19-6-8
 * @description: Pass
 */
public class UserImpl implements User {
    @Override
    public void walk() {
        System.out.println("正在走路");
    }

    @Override
    public void say() {
        System.out.println("正在说话");
    }

    @Override
    public void sleep() {
        System.out.println("正在睡觉");
    }
}
