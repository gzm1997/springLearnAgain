package cn.gzm.dynamicProxy.proxy;

import cn.gzm.staticProxy.dao.Rent;

import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.ResultSet;

/**
 * @author: gzm
 * @date: 19-6-6
 * @description: Pass
 */
public class ProxyMen implements InvocationHandler {
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    /*
    * 生成代理类*/
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        Object result;
        try {
            result = method.invoke(this.target, args);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }
}
