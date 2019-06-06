package cn.gzm.dynamicProxy.dao.impl;

import cn.gzm.dynamicProxy.dao.User;

/**
 * @author: gzm
 * @date: 19-6-6
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
