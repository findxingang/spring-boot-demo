package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.web.context.support.ServletRequestHandledEvent;

import java.net.InetAddress;

@SpringBootApplication
@ServletComponentScan
public class FilterDemoApplication implements ApplicationListener<ServletRequestHandledEvent> {

    public static void main(String[] args) {
        // 启用 ANSI 颜色输出 方法1
        System.setProperty("spring.output.ansi.enabled", "ALWAYS");
        SpringApplication.run(FilterDemoApplication.class, args);
    }

    @Bean
    @Order(Ordered.LOWEST_PRECEDENCE)
    CommandLineRunner commandLineRunner(Environment environment) {
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

    /**
     * 监听接口的请求耗时
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ServletRequestHandledEvent event) {
        // Throwable failureCause = event.getFailureCause() ;
        // if (failureCause != null) {
        //     System.err.printf("错误原因: %s%n", failureCause.getMessage()) ;
        // }
        // System.err.printf("请求客户端地址：%s, 请求URL: %s, 请求Method: %s, 请求耗时: %d%n",
        //         event.getClientAddress(),
        //         event.getRequestUrl(),
        //         event.getMethod(),
        //         event.getProcessingTimeMillis()) ;
    }
}
