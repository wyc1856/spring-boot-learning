package club.wyc1856.spring.bean.definition;

import club.wyc1856.dependency.ioc.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean 别名示例
 *
 * @author wyc1856
 * @date 2020/2/12
 **/
public class BeanAliasDemo {

    public static void main(String[] args) {
        //定义应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definitions-context.xml");
        //通过原名查询
        User user = beanFactory.getBean("user", User.class);
        //通过别名查询
        User wyc1856User = beanFactory.getBean("wyc1856-user", User.class);
        //对比
        System.out.println("原名user和别名wyc1856-user查询的bean是否相同：" + (user == wyc1856User));
    }
}
