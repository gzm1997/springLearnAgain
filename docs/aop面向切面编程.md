# aop面向切面编程

标签： java aop


----------
## aop简介 ##
aspect oriented programming面向切面编程，其实在静态代理和动态代理的时候，就是使用了aop的编程思想。他在一个切面上允许我们横向编程，不改变原有领域业务的情况下，在切面上进行动态的拓展。

横向的编程：

![image.png-12.5kB][1]

上图中我们根据之前动态代理的一个日志为例，可以看见，这里的领域业务是Service，我们在不改变领域业务的情况下，横向增加了公共业务Log日志。这样当日志业务需要拓展更改的时候，领域业务的代码不需要被更改。

aop优点(其实就是使用代理的优点)：

 1. 使得真正角色处理的业务更加纯粹，不用再去关系一些公共业务
 2. 公共业务由代理来完成，实现业务分工
 3. 公共业务发生拓展的时候更加集中和方便

aop的一般使用场景：

 - 日志
 - 安全
 - 缓存
 - 事务
 - 异常处理

aop关键名词：

 - 关注点　就是上面提到的使用场景，日志　安全　缓存　事务　异常处理等　在这些方面进行横向编程
 - 切面　一个关注点的模块化　比如所有日志操作都封装为一个类
 - 连接点　就是某个方法被执行
 - 通知　指的某个方法执行的前后执行的动作　有：
    * 前置通知　在连接点之前执行
    * 后置通知　在连接点之后执行
    * 异常通知　在方法抛出异常退出时执行
    * 最终通知　当某个连接点退出时执行
    * 环绕通知　在连接点前后都执行一次　要注意前后都优先于前置和后置通知
 - 织入　把切面连接到其他应用程序或者对象上


----------
## 实现aop的三种方式 ##
在spring中实现aop主要有三种方式：

 1. 实现spring aop接口
 2. 自定义类实现aop
 3. 注释实现aop


----------
## 实现spring aop接口 ##
按照在前置通知为例子，只需要实现MethodBeforeAdvice接口，这个接口只有一个方法：
```java
public interface MethodBeforeAdvice extends BeforeAdvice {
    void before(Method var1, Object[] var2, Object var3) throws Throwable;
}
```
日志类：
```java
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
```
目标类：
```java
public class UserImpl implements User {
    @Override
    public void walk() {
        System.out.println("正在走路");
    }

    @Override
    public void say() {
        System.out.println("正在说话");
    }

    @Override
    public void sleep() {
        System.out.println("正在睡觉");
    }
}
```
配置文件：
```
    <bean id="user" class="cn.gzm.aop.aopByInterface.dao.impl.UserImpl"/>
    <bean id="log" class="cn.gzm.aop.aopByInterface.log.Log"/>
    <aop:config>
        <aop:pointcut id="pointcut" expression="execution(* cn.gzm.aop.aopByInterface.dao.impl.*.*(..))"/>
        <aop:advisor advice-ref="log" pointcut-ref="pointcut"/>
    </aop:config>
```
配置文件这里简直折腾死我了，这也是我不推荐这个实现aop接口的方法，需要在配置文件头引入如下部分：
![image.png-130.2kB][2]
除此之外，除了需要常规的spring jar包还需要自己额外倒入**aspectjweaver.jar**，否则报错。在idea上实现的方式是在project structure -> Modules -> Dependencies -> + jar包

最后使用idea以来存储方式是在iml配置文件上形成如下：

    <orderEntry type="module-library" exported="">
      <library>
        <CLASSES>
          <root url="jar://$USER_HOME$/下载/aspectjweaver-1.8.5.jar!/" />
        </CLASSES>
        <JAVADOC />
        <SOURCES />
      </library>
    </orderEntry>

 最终运行效果：
 ![image.png-32.3kB][3]
 可以看见，因为实现的日志类是在每个方法之前打印这个目标类的哪个方法被调用，所以运行效果是符合预期的。
 
 
 
 


  [1]: http://static.zybuluo.com/gzm1997/s5nkj4thzmji34nhmn5u0v07/image.png
  [2]: http://static.zybuluo.com/gzm1997/q75shr6wvg92y3wwhwjtywjn/image.png
  [3]: http://static.zybuluo.com/gzm1997/gx1kgrmj014hk7t8k3dju9q3/image.png