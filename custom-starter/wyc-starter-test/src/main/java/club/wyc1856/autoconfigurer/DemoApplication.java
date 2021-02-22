package club.wyc1856.autoconfigurer;

import club.wyc1856.autoconfigurer.service.WycAutoConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author wyc1856
 * @date 2021/2/20
 **/
@Slf4j
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);
        WycAutoConfiguration.WycService wycService = applicationContext.getBean(WycAutoConfiguration.WycService.class);
        log.info("auto configurer hello: {}", wycService.hello("wyc"));
    }
}
