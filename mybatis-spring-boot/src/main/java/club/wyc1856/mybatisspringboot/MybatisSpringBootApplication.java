package club.wyc1856.mybatisspringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "club.wyc1856.mybatisspringboot.mapper")
public class MybatisSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisSpringBootApplication.class, args);
	}

}
