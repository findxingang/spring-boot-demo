package com.example.demo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author wangxingang
 * @since 2024/8/9
 */
@WebFilter("/*")
public class MyFilter2 implements Filter {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("过滤器初始化完成 2");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 对请求进行预处理，如权限处理、IP过滤、敏感词过滤、跨域处理等等
        logger.info("doFilter 2");
        // 预处理完成后判断是否允许放行，调用filterChain.doFilter()方法会回调过滤链里所有的过滤器，
        // 所有过滤器处理完并调用此方法后请求会到达servlet，
        // 如果任一过滤器未调用此方法都会导致请求无法到达servlet，即请求被拦截，shiro权限控制框架即是通过此接口实现
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        logger.info("过滤器销毁完毕 2");
    }
}
