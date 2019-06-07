package cn.gzm.dynamicProxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: gzm
 * @date: 19-6-6
 * @description: Pass
 */
public class LogProxy implements InvocationHandler {
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    /*
    * 生成一个代理类的实例*/
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
    /*
    * 在代理对象中执行被引用的方法，
    * 注意：这个方法会在当被代理方法的某个方法method被调用的时候进行调用，
    * 返回被代理对象特定方法的返回值*/
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        Object result;
        log(method.getName());
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
    private void log(String methohName) {
        System.out.println("日志:正在执行" + methohName + "函数");
    }
}
