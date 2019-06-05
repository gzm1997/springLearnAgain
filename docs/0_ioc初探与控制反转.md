# 控制反转初探

标签： java spring


----------
## spring简介 ##
spring就是春天的意思，意为为软件行业带来了春天。它其实是一个大杂烩，将很多已有的框架技术整合起来。

优点：

 - 轻量级框架　没有侵入性
 - ioc容器　控制反转
 - aop面向切面编程
 - 对事务支持
 - 对框架支持等

结构：
![spring的结构][1]
上面的aop就是面向切面编程
core container就是ioc控制反转



----------
## beans使用例子 ##
步骤：

 1. 导入jar包
 2. 编写spring配置文件
 3. 编写bean工厂将控制管理的class
 4. 编写测试函数

导入的jar包，可以自己手动导入，但是使用idea生成更方便，这也是我很喜欢idea的原因
![需要导入的spring jar包][2]

编写的spring配置文件，idea也可以自动生成。其实以前我是很想不明白，明明可以在程序本身生成和管理这些对象，为什么偏偏要在这个蛋疼的配置文件中生成和管理对象，直到我了解了spring的控制反转思想，我才知道这是很有必要的，这个点下面会说。
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    <bean name="User" class="cn.gzm.beans.User">
        <property name="name" value="郭柱明"></property>
    </bean>
</beans>
```

编写需要bean工厂生成和管理的class
```java
public class User {
    private String name;

    public User() {
        System.out.println("User正在被创建");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```

测试函数
```java
public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        User user = (User) applicationContext.getBean("User");
        System.out.println(user.getName());
    }
}
```

测试函数运行效果
![运行效果][3]


思考问题
这个User对象其实是由spring容器创建的，它的属性是在配置文件中被设置的，值得一提的是User必须含有set函数，否则配置文件无法给其中的name字段设值。


----------
## 控制翻转 ##
以前我们没有使用框架的时候，一般都是在程序本身之间创建和管理对象的，这样dao和服务层就耦合在一起了，现在spring允许我们的程序不创建对象，只是接受对象，实现解耦，让我们程序员可以将主要经历放在业务层中。

所谓控制就是对对象创建的控制，由以前的程序直接创建变为spring容器创建
所谓翻转就是程序本身的主动创建，变为被动地接受对象。

其实理解这一思想很重要，不然就像我以前一样，都不知道bean是干什么用的，甚至觉得有点鸡肋和多余。

控制反转是一种思想，由主动编程变为被动接收。它可以放我们实现解耦，不需要修改程序，只需要修改配置文件即可。


----------
## spring配置文件编写 ##

１．使用无参构造函数来创建
class的无参构造函数
```
    public UserDataServiceImpl() {
        System.out.println("这是UserDataServiceImpl无参构造函数");
    }
```
配置文件
```
    <bean id="mysql" class="cn.gzm.app.dao.impl.UserGetByMysql"/>
    <bean id="oracle" class="cn.gzm.app.dao.impl.UserGetByOracle"/>

    <bean id="service" class="cn.gzm.app.service.impl.UserDataServiceImpl">
        <property name="userDao" ref="mysql"/>
    </bean>
```
运行效果

![image.png-14.3kB][6]

很有意思的是，class的字段值的设置是通过set函数来设置的，即使在没有set函数但是有有参构造函数的情况下也是不可以的，运行会报错。

２．使用有参构造函数来创建
class的有参构造函数
```
    public UserDataServiceImpl(UserDao userDao) {
        System.out.println("这是UserDataServiceImpl有参构造函数");
        this.userDao = userDao;
    }
```
配置文件
```
    <bean id="mysql" class="cn.gzm.app.dao.impl.UserGetByMysql"/>
    <bean id="oracle" class="cn.gzm.app.dao.impl.UserGetByOracle"/>

    <bean id="service" class="cn.gzm.app.service.impl.UserDataServiceImpl">
        <constructor-arg name="userDao" ref="mysql"></constructor-arg>
    </bean>
```
运行效果

![image.png-14.5kB][9]

这里在配置文件中使用**constructor-arg**来对对象中字段进行赋值，除了有name-value还有index-value等多种方式

３．使用静态工厂方法来创建，有时候需要一个class只创建一个对象，这时候需要使用静态工厂来创建这个唯一的对象
静态工厂class
```java
public class ServiceFactory {
    public static UserDataServiceImpl newInstance(UserDao userDao) {
        System.out.println("使用静态方法工厂创建对象");
        return new UserDataServiceImpl(userDao);
    }
}
```
配置文件
```
    <bean id="service" class="cn.gzm.app.service.factory.ServiceFactory" factory-method="newInstance">
        <constructor-arg name="userDao" ref="mysql"></constructor-arg>
    </bean>
```

４．使用动态工厂方法创建对象
动态工厂class
```java
public class ServiceDynamicFactory {
    public UserDataServiceImpl newInstance(UserDao userDao) {
        System.out.println("使用动态工厂方法创建对象");
        return new UserDataServiceImpl(userDao);
    }
}
```
配置文件
```
    <bean id="dynamicFactory" class="cn.gzm.app.service.factory.ServiceDynamicFactory"/>
    <bean id="service" factory-bean="dynamicFactory" factory-method="newInstance">
        <constructor-arg name="userDao" ref="mysql"></constructor-arg>
    </bean>
```
运行
![image.png-22kB][10]

bean可以设置多个别名，但是这个其实不是很重要，我们在测试函数中getBean获取这个对象的时候可以根据id也可以根据name。那么如果我们在配置文件中既没有给对象设置id，也没有设置name，是可以通过对象的class来获取的。像下面这样：

    UserDataService userDataService = (UserDataService) context.getBean(UserDataServiceImpl.class);

但是当配置文件中有多个符合要求的对象被返回，那么就会报错。

５．团队写作，多个配置文件
需要import的配置文件config.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    <!--无论你用不用　下面两个bean都会被创建　其实所有的bean都会被创建-->
    <bean id="mysql" class="cn.gzm.app.dao.impl.UserGetByMysql"/>
    <bean id="oracle" class="cn.gzm.app.dao.impl.UserGetByOracle"/>

    <bean id="dynamicFactory" class="cn.gzm.app.service.factory.ServiceDynamicFactory"/>
    <bean id="service" factory-bean="dynamicFactory" factory-method="newInstance">
        <constructor-arg name="userDao" ref="mysql"></constructor-arg>
    </bean>
</beans>
```
在主配置文件中import

    <import resource="config.xml"/>





  [1]: https://docs.spring.io/spring/docs/4.3.22.RELEASE/spring-framework-reference/htmlsingle/images/spring-overview.png
  [2]: http://static.zybuluo.com/gzm1997/h8bth4ekxvnh1znn9ey0easp/image.png
  [3]: http://static.zybuluo.com/gzm1997/a1r472cs34jmwoz37ru1f81c/image.png
  [4]: http://static.zybuluo.com/gzm1997/qigban8e64wcjht38witq7wx/image.png
  [5]: http://static.zybuluo.com/gzm1997/k08n0sgr2pzis81tza69qwzd/image.png
  [6]: http://static.zybuluo.com/gzm1997/0egkg9lgotnp5sjbnvii6b9d/image.png
  [7]: http://static.zybuluo.com/gzm1997/nrj6rmdegf0ejs6l59h2o2yu/image.png
  [8]: http://static.zybuluo.com/gzm1997/sjbgs77tn525l925095sjfwz/image.png
  [9]: http://static.zybuluo.com/gzm1997/twv4y89hh7oc787zs7cpnv7u/image.png
  [10]: http://static.zybuluo.com/gzm1997/ixi9ezzr05t9lmluqmmfp2z2/image.png