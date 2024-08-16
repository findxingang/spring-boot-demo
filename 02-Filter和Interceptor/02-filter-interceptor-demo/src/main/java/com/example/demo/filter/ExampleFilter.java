package com.example.demo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author wangxingang
 * @since 2024/8/9
 */
@WebFilter("/example/*") // 任何访问以 "/example/" 开头的 URL 的请求都会被这个过滤器拦截
public class ExampleFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初始化代码
        System.out.println("ExampleFilter 初始化. Filter 名称: " + filterConfig.getFilterName());
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 获取请求信息
        String remoteAddr = request.getRemoteAddr();
        String requestUri = ((HttpServletRequest) request).getRequestURI();

        // 请求预处理
        System.out.println("ExampleFilter 开始处理请求. 请求来源 IP: " + remoteAddr + ", 请求 URI: " + requestUri);

        // 继续调用链中的下一个过滤器或目标资源
        System.out.println("ExampleFilter 调用过滤器链中的下一个元素.");
        chain.doFilter(request, response);

        // 响应后处理
        System.out.println("ExampleFilter 请求处理完毕. 响应返回客户端.");
    }

    @Override
    public void destroy() {
        // 资源清理代码
        System.out.println("ExampleFilter 被销毁了");
        Filter.super.destroy();
    }
}
