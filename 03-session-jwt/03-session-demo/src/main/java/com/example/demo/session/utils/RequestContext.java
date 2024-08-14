package com.example.demo.session.utils;

import com.example.demo.doamin.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 通过SpringMVC提供的RequestContextHolder对象在程序任何地方获取到当前请求对象，
 * 从而获取我们保存在HttpSession中的用户对象。
 * 这样就不用在 Controller 层获取再传入 Service 层了
 * @author wangxingang
 * @since 2024/8/14
 */
public class RequestContext {
    public static HttpServletRequest getCurrentRequest() {
        // 通过`RequestContextHolder`获取当前request请求对象
        return ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
    }

    public static User getCurrentUser() {
        // 通过request对象获取session对象，再获取当前用户对象
        return (User)getCurrentRequest().getSession().getAttribute("user");
    }
}
