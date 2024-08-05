package com.example.demo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

/**
 * 自定义的过滤器，实现根据IP统计访问次数
 *
 * <p>
 *     1. Filter 依赖于 Servlet 容器，属于 Servlet 规范的一部分，而 Interceptor 则属于 SpringMVC 规范的一部分
 *     2. Filter 的生命周期由 Servlet 容器管理，而 Interceptor 则由 SpringMVC 管理，可以通过注入等方式来获取其 Bean 的实例
 *     3. Filter 可以拦截所有的 Web 资源（包括 JSP、Servlet、静态资源），而 Interceptor 只能拦截 Controller 的资源
 * </p>
 * @author xingang
 * @since 2024/7/18 09:50
 */
@WebFilter(urlPatterns = "/*")
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 访问的ip
        HttpServletRequest req = (HttpServletRequest) request;
        String ip = req.getRemoteAddr();

        // 统计访问次数并输出
        HttpSession session = req.getSession();
        Integer count = (Integer) session.getAttribute("count");
        count = Objects.isNull(count) ? 1 : ++count;
        System.out.println("ip:" + ip + "\t count:" + count);
        session.setAttribute("count", count);

        // 放行
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
