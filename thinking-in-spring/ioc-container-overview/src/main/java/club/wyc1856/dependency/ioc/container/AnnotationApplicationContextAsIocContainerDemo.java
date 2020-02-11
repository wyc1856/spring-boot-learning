package club.wyc1856.dependency.ioc.container;

import club.wyc1856.dependency.ioc.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * 注解类型的 {@link ApplicationContext} 作为Ioc容器示例
 *
 * @author wyc1856
 * @date 2020/2/11
 **/
public class AnnotationApplicationContextAsIocContainerDemo {

    public static void main(String[] args) {
        //创建注解类型的ApplicationContext
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //将当前类当做配置类进行加载
        applicationContext.register(AnnotationApplicationContextAsIocContainerDemo.class);
        //启动应用上下文
        applicationContext.refresh();
        //按类型查找bean集合
        lookupCollectionByType(applicationContext);
        //关闭应用上下文
        applicationContext.close();
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beansOfType = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("User 类型的bean包括：" + beansOfType);
        }
    }

    @Bean
    public User annotationUser() {
        User user = new User();
        user.setId(1L);
        user.setName("注解类型User");
        return user;
    }
}
