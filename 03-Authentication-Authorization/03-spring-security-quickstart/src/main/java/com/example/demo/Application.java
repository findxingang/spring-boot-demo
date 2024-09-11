package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

/**
 * @author wangxingang
 */
@Slf4j
@SpringBootApplication
public class Application {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
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
    }

    @Bean
    CommandLineRunner commandLineRunner(ApplicationContext applicationContext) {
        return args -> {
            log.info("打印 AuthenticationManager：--------------------");
            Map<String, SecurityFilterChain> beansOfType = applicationContext.getBeansOfType(SecurityFilterChain.class);
            System.out.println();

            log.info("打印 PasswordEncoder：--------------------");
            Map<String, PasswordEncoder> beansOfType1 = applicationContext.getBeansOfType(PasswordEncoder.class);
            System.out.println();
        };
    }

}
