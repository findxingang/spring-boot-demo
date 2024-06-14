package com.example.rediscommand;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;

import java.net.InetAddress;

/**
 * @author xingang
 * @since 2024/06/04 09:30
 */
@SpringBootApplication
public class RedisCommandApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisCommandApplication.class, args);
    }

    @Bean
    @Order(Ordered.LOWEST_PRECEDENCE)
    public CommandLineRunner commandLineRunner(Environment environment) {
        return args -> {
            String appName = environment.getProperty("spring.application.name") != null ? environment.getProperty("spring.application.name") : "";
            String port = environment.getProperty("server.port") != null ? environment.getProperty("server.port") : "8080";
            String path = environment.getProperty("server.servlet.context-path") != null ? environment.getProperty("server.servlet.context-path") : "";
            String ip = InetAddress.getLocalHost().getHostAddress();
            System.out.println(
                    "\n\n\t" +
                            "----------------------------------------------------------\n\t" +
                            "Application " + appName +" is running! Access URLs:\n\t" +
                            "Local: \t\thttp://localhost:" + port + path + "/\n\t" +
                            "External: \thttp://" + ip + ":" + port + path + "/\n\n\t" +
                            "------------------------------------------------------------"
            );
        };
    }
}
