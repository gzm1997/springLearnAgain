package cn.gzm.test;

import cn.gzm.beans.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: gzm
 * @date: 19-6-4
 * @description: Pass
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        User user = (User) applicationContext.getBean("User");
        System.out.println(user.getName());
    }
}
