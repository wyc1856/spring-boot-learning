package club.wyc1856.spring.bean.definition;

import club.wyc1856.dependency.ioc.domain.User;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * 注册 {@link org.springframework.beans.factory.config.BeanDefinition} 示例
 *
 * @author wyc1856
 * @date 2020/2/12
 **/
public class BeanDefinitionRegistrationDemo {

    public static void main(String[] args) {
        //定义应用上下文
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //定义beanDefinition
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("id", 1).addPropertyValue("name", "wyc1856");
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        //1.命名方式注册 BeanDefinition
        applicationContext.registerBeanDefinition("userBean", beanDefinition);
        //2.非命名方式注册 BeanDefinition
        BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition, applicationContext);
        //启动应用上下文
        applicationContext.refresh();
        //依赖查询注册的 user bean
        Map<String, User> userBeans = applicationContext.getBeansOfType(User.class);
        System.out.println(userBeans);
        //关闭应用上下文
        applicationContext.close();
    }
}
