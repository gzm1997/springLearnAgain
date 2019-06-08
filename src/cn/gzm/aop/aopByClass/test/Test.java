package cn.gzm.aop.aopByClass.test;

import cn.gzm.aop.aopByClass.dao.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: gzm
 * @date: 19-6-8
 * @description: Pass
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/aopXml/aop1.xml");
        User user = (User) applicationContext.getBean("user");
        user.walk();
        user.say();
        user.sleep();
    }
}
