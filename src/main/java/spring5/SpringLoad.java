package spring5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import spring5.config.SpringConfig;

public class SpringLoad {
    public static void main(String[] args) throws Exception {
        //ApplicationContext的两个实现类
        // 1.ClassPathXmlApplicationContext,2.FileSystemXmlApplicationContext
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/applicationContext.xml");
        SpringBean springBean = applicationContext.getBean("springBean", SpringBean.class);
        springBean.method();

        //通过加载配置加载spring配置
        ApplicationContext applicationContext1 = new AnnotationConfigApplicationContext(SpringConfig.class);
        SpringBean springBean1 = applicationContext1.getBean("springBean", SpringBean.class);
        springBean1.method();

        while (true) {
            springBean1.method();
        }

        //IOC的操作：bean管理

        // bean管理操作：1.创建对象；2.属性注入
        // bean管理两种操作方式：1.XML配置；2.注解

        //XML方式：
        /*
            1.设值注入：
            <property name = "", value = ""></property>
            也可以引用p名称空间注入
            <bean id ="" class="" p:字段名称="value"></bean>

            2.构造注入：
            <constructor-arg name = "" value = ""></constructor-arg>
         */
    }
}
