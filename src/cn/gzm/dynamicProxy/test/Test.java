package cn.gzm.dynamicProxy.test;

import cn.gzm.dynamicProxy.dao.User;
import cn.gzm.dynamicProxy.dao.impl.UserImpl;
import cn.gzm.dynamicProxy.proxy.LogProxy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: gzm
 * @date: 19-6-6
 * @description: Pass
 */
public class Test {
    public static void main(String[] args) {
        User user = new UserImpl();
        LogProxy logProxy = new LogProxy();
        logProxy.setTarget(user);
        User proxyUser = (User) logProxy.getProxy();
        proxyUser.walk();
        proxyUser.say();
        proxyUser.sleep();
        System.out.println();

        List<String> list = new ArrayList<>();
        logProxy.setTarget(list);
        /*
        * 从这里可以发现　在动态代理的情况下，代理类都是可以被被代理类的引用指向的*/
        List<String> listProxy = (List<String>) logProxy.getProxy();
        listProxy.add("lala");
    }
}
