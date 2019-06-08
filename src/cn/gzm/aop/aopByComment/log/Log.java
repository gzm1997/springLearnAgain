package cn.gzm.aop.aopByComment.log;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author: gzm
 * @date: 19-6-8
 * @description: Pass
 */

@Aspect
public class Log {
    @Before("execution(* cn.gzm.aop.aopByComment.dao.impl.*.*(..))")
    public void before() {
        System.out.println("方法执行前");
    }
}
