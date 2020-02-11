package club.wyc1856.dependency.ioc.container;

import club.wyc1856.dependency.ioc.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * {@link BeanFactory} 作为Ioc容器示例
 *
 * @author wyc1856
 * @date 2020/2/11
 **/
public class BeanFactoryAsIocContainerDemo {

    public static void main(String[] args) {
        //创建BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //声明Xml资源读取器
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        //加载Xml配置
        String location = "classpath:/META-INF/dependency-lookup-context.xml";
        int beanDefinitionCount = xmlBeanDefinitionReader.loadBeanDefinitions(location);
        System.out.println("加载了" + beanDefinitionCount + "个beanDefinition");
        //按类型查找bean集合
        lookupCollectionByType(beanFactory);
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beansOfType = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("User 类型的bean包括：" + beansOfType);
        }
    }
}
