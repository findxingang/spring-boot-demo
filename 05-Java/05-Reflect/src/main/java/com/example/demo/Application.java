package com.example.demo;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.example.demo.domain.DemoData;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    public ApplicationRunner applicationRunner() {
        return args -> {
            String fileName = "动态表头" + System.currentTimeMillis() + ".xlsx";
            List<DemoData> list = new ArrayList<>();
            list.add(DemoData.builder().string("字符串1").doubleData(1.111).date(new Date()).ignore("ignore").dynamicHead("dynamicHead").build());
            list.add(DemoData.builder().string("字符串2").doubleData(2.222).date(new Date()).ignore("ignore").dynamicHead("dynamicHead").build());

            // 利用反射动态修改注解的属性值
            Class<DemoData> clazz = DemoData.class;
            String fieldName = "dynamicHead";
            Class<ExcelProperty> annotationClass = ExcelProperty.class;
            String propertyName = "value";
            String param = "bbb";
            String[] newValue = getNewValue(param);
            modifyAnnotationValue(clazz, fieldName, annotationClass, propertyName, newValue);

            EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(list);
        };
    }

    /**
     * 生成新的属性值
     */
    private String[] getNewValue(String param) {
        return param.equals("aaa") ? new String[]{"AAA"} : new String[]{"BBB"};
    }

    /**
     * 根据变量修改类字段注解的属性值
     * @param clazz           哪个类
     * @param fieldName       哪个字段
     * @param annotationClass 哪个注解
     * @param propertyName    哪个属性
     * @param newValue        新的属性值
     */
    public void modifyAnnotationValue(Class<?> clazz, String fieldName, Class<? extends Annotation> annotationClass, String propertyName, Object newValue) {
        try {
            // 获取字段
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);

            // 获取字段上的注解
            Annotation annotation = field.getAnnotation(annotationClass);
            if (annotation == null) {
                throw new IllegalArgumentException("Field " + fieldName + " does not have annotation " + annotationClass.getName());
            }

            // 通过反射获取注解的代理对象
            InvocationHandler handler = Proxy.getInvocationHandler(annotation);

            // 获取代理对象的成员值 map
            Field memberValuesField = handler.getClass().getDeclaredField("memberValues");
            memberValuesField.setAccessible(true);
            Map<String, Object> memberValues = (Map<String, Object>) memberValuesField.get(handler);

            // 检查 propertyName 是否存在
            if (!memberValues.containsKey(propertyName)) {
                throw new IllegalArgumentException("Property " + propertyName + " does not exist in annotation " + annotationClass.getName());
            }

            // 修改注解的属性值，保持类型一致
            Object oldValue = memberValues.get(propertyName);
            if (oldValue != null && !oldValue.getClass().isAssignableFrom(newValue.getClass())) {
                throw new IllegalArgumentException("New value type " + newValue.getClass().getName() + " is not compatible with the existing type " + oldValue.getClass().getName());
            }

            // 修改注解的值
            memberValues.put(propertyName, newValue);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("修改注解的属性值发生异常", e);
        }
    }

}
