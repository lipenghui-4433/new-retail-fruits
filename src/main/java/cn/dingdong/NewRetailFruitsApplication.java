package cn.dingdong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.dingdong.mapper")
public class NewRetailFruitsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewRetailFruitsApplication.class, args);
	}

}
