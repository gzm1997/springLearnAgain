package cn.gzm.app.test;

import cn.gzm.app.service.UserDataService;
import cn.gzm.app.service.impl.UserDataServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: gzm
 * @date: 19-6-4
 * @description: Pass
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("xml/iocXml/beans.xml");
        UserDataService userDataService = (UserDataService) context.getBean(UserDataServiceImpl.class);
        userDataService.getUser();
    }
}
