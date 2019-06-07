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

        List<String> list = new ArrayList<>();
        logProxy.setTarget(list);
        List<String> listProxy = (List<String>) logProxy.getProxy();
        listProxy.add("lala");
    }
}
