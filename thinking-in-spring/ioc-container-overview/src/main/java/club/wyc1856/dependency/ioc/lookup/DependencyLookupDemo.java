package club.wyc1856.dependency.ioc.lookup;

import club.wyc1856.dependency.ioc.annotation.Supper;
import club.wyc1856.dependency.ioc.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * 依赖查找
 *
 * @author wyc1856
 * @date 2020/1/9
 **/
public class DependencyLookupDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");
        //按名称查找单一bean
        User user = (User) beanFactory.getBean("user");
        System.out.println(user);

        //按类型查找单一bean（存在多个bean且未标记最主要的bean时会抛出异常）
        User users = beanFactory.getBean(User.class);
        System.out.println(users);

        //按类型查找bean集合
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> userList = listableBeanFactory.getBeansOfType(User.class);
            System.out.println(userList);
        }

        //按注解查找bean集合
        Map<String, Object> usersWithAnnotation = ((ListableBeanFactory) beanFactory).getBeansWithAnnotation(Supper.class);
        System.out.println("按注解查找bean集合：" +usersWithAnnotation);

        //延迟查找
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean(ObjectFactory.class);
        User objectUser = objectFactory.getObject();
        System.out.println(objectUser);

        //依赖查找只能查找 一般的bean（包括自定义的bean和spring内建的bean）
        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println(environment);

        //无法查找spring内建的依赖
//        BeanFactory beanFactoryBean = beanFactory.getBean(BeanFactory.class);
    }
}
