package com.example.demo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * 自定义的拦截器，实现根据IP统计访问次数
 * <p>
 *     1. Filter 依赖于 Servlet 容器，属于 Servlet 规范的一部分，而 Interceptor 则属于 SpringMVC 规范的一部分
 *     2. Filter 的生命周期由 Servlet 容器管理，而 Interceptor 则由 SpringMVC 管理，可以通过注入等方式来获取其 Bean 的实例
 *     3. Filter 可以拦截所有的 Web 资源（包括 JSP、Servlet、静态资源），而 Interceptor 只能拦截 Controller 的资源
 * </p>
 * @author xingang
 * @since 2024/7/18 09:50
 */
@WebFilter(urlPatterns = "/*")
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 访问的ip
        String ip = request.getRemoteHost();

        // 统计访问次数并输出
        HttpSession session = request.getSession();
        Integer count = (Integer) session.getAttribute("count");
        count = Objects.isNull(count) ? 1 : ++count;
        System.out.println("ip:" + ip + "\t count:" + count);
        session.setAttribute("count", count);

        // 放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
