package cn.gzm.aop.aopByInterface.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author: gzm
 * @date: 19-6-8
 * @description: Pass
 */
public class Log implements MethodBeforeAdvice {
    /*
    * metod　被调用的方法
    * args 被调用的方法的参数
    * target 被调用方法的对象
    * */
    @Override
    public void before(Method method, Object[] args, Object target) {
        System.out.println(target.getClass().getName() + "正在调用" + method.getName());
    }
}
