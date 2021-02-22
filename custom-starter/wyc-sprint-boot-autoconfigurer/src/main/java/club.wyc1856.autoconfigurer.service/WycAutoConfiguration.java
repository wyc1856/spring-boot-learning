package club.wyc1856.autoconfigurer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义自动配置类
 *
 * @author wyc1856
 * @date 2021/2/20
 **/
@Configuration
@ConditionalOnWebApplication
@ConditionalOnProperty(name = "autoconfig.enable.wyc", havingValue = "true")
@EnableConfigurationProperties(WycConfigProperties.class)
public class WycAutoConfiguration {

    @Bean
    public WycService wycService() {
        return new WycService();
    }

    public static class WycService {

        @Autowired
        private WycConfigProperties properties;

        public String hello(String name) {
            return properties.getPrefix() + name + properties.getSuffix();
        }
    }
}
