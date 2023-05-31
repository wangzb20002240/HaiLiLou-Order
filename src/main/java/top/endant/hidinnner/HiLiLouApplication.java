package top.endant.hidinnner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HiLiLouApplication {

    public static void main(String[] args) {
        System.out.println("服务器启动中...");
        SpringApplication.run(HiLiLouApplication.class, args);
    }

}