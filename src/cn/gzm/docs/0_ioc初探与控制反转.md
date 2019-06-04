# spring学习２

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

  [1]: https://docs.spring.io/spring/docs/4.3.22.RELEASE/spring-framework-reference/htmlsingle/images/spring-overview.png
  [2]: http://static.zybuluo.com/gzm1997/h8bth4ekxvnh1znn9ey0easp/image.png
  [3]: http://static.zybuluo.com/gzm1997/a1r472cs34jmwoz37ru1f81c/image.png