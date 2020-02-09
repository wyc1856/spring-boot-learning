package club.wyc1856.dependency.ioc.injection;

import club.wyc1856.dependency.ioc.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * 依赖注入
 *
 * @author wyc1856
 * @date 2020/1/9
 **/
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");

        //依赖来源一：自定义Bean
        UserRepository userRepository = beanFactory.getBean(UserRepository.class);
        System.out.println("自定义Bean：" + userRepository.getUsers());

        //依赖来源二：内建依赖（只能通过依赖注入，不能通过依赖查找）
        BeanFactory internalBeanFactory = userRepository.getBeanFactory();
        System.out.println("内建依赖：" + internalBeanFactory);
        System.out.println("内建依赖BeanFactory和自己声明的BeanFactory是否是相同的Bean：" + (internalBeanFactory == beanFactory));
//        System.out.println("依赖查找内建依赖：" + lookupInternalDependency(beanFactory));

        ObjectFactory<ApplicationContext> objectFactory = userRepository.getObjectFactory();
        System.out.println("延迟查找注入的BeanFactory和自己声明的BeanFactory是否是相同的Bean：" + (objectFactory.getObject() == beanFactory));

        //依赖来源三：内建Bean
        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println(environment);
    }

    private static BeanFactory lookupInternalDependency(BeanFactory beanFactory) {
        try {
            return beanFactory.getBean(BeanFactory.class);
        } catch (Exception e) {
            System.err.println("依赖查找内建依赖失败：" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
