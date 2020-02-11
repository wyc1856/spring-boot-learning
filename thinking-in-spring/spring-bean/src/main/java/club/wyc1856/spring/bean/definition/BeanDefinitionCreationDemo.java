package club.wyc1856.spring.bean.definition;

import club.wyc1856.dependency.ioc.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * {@link BeanDefinition} 创建示例
 *
 * @author wyc1856
 * @date 2020/2/11
 **/
public class BeanDefinitionCreationDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //1.通过 BeanDefinitionBuilder 创建
        createByDefinitionBuilder(applicationContext);
        //2.通过 AbstractBeanDefinition 派生类创建
        createByGenericBeanDefinition(applicationContext);
        //启动应用上下文
        applicationContext.refresh();
        Map<String, User> userBeans = applicationContext.getBeansOfType(User.class);
        System.out.println(userBeans);
        //关闭应用上下文
        applicationContext.close();
    }

    private static void createByDefinitionBuilder(AnnotationConfigApplicationContext applicationContext) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder
                .addPropertyValue("id", 1)
                .addPropertyValue("name", "wyc1856");
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        applicationContext.registerBeanDefinition("userCreatedByDefinitionBuilder", beanDefinition);
    }

    private static void createByGenericBeanDefinition(AnnotationConfigApplicationContext applicationContext) {
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("id", 2).add("name", "wyc1995");
        genericBeanDefinition.setPropertyValues(propertyValues);
        applicationContext.registerBeanDefinition("userCreatedByGenericBeanDefinition", genericBeanDefinition);
    }
}
