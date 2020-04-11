package club.wyc1856.web.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 主启动类
 *
 * @author wyc1856
 * @date 2020/4/11
 **/
@Slf4j
@SpringBootApplication
public class WebApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApiApplication.class, args);
        log.info("服务启动完成>>>>>");
    }
}
