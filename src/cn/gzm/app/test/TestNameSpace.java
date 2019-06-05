package cn.gzm.app.test;

import cn.gzm.app.dao.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: gzm
 * @date: 19-6-5
 * @description: Pass
 */
public class TestNameSpace {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        User user = (User) applicationContext.getBean(User.class);
        System.out.println(user.getName());
    }
}
