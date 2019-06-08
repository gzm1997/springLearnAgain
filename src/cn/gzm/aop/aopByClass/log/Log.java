package cn.gzm.aop.aopByClass.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author: gzm
 * @date: 19-6-8
 * @description: Pass
 */
public class Log {
    public void before() {
        System.out.println("方法执行前");
    }
}
