package cn.gzm.dynamicProxy.test;

import cn.gzm.dynamicProxy.dao.User;
import cn.gzm.dynamicProxy.dao.impl.UserImpl;
import cn.gzm.dynamicProxy.proxy.ProxyMen;

/**
 * @author: gzm
 * @date: 19-6-6
 * @description: Pass
 */
public class Test {
    public static void main(String[] args) {
        User user = new UserImpl();
        ProxyMen proxyMen = new ProxyMen();
        proxyMen.setTarget(user);
        User proxyUser = (User) proxyMen.getProxy();
        proxyUser.walk();
    }
}
