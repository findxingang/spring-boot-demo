package com.example.demo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wangxingang
 * @since 2024/8/9
 */
public class ExampleInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 获取请求信息
        String requestUri = request.getRequestURI();
        String method = request.getMethod();
        String remoteAddr = request.getRemoteAddr();

        // 请求处理前调用
        System.out.println("ExampleInterceptor: 开始拦截请求. 请求 URI: " + requestUri + ", HTTP 方法: " + method + ", 请求来源 IP: " + remoteAddr);

        return true; // 返回 true 继续处理请求，返回 false 取消请求处理
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // 请求处理后，视图渲染之前调用
        System.out.println("ExampleInterceptor: 控制器已处理请求. 请求 URI: " + request.getRequestURI());

        // 如果视图模型存在，输出模型信息
        if (modelAndView != null) {
            System.out.println("ExampleInterceptor: ModelAndView 信息: " + modelAndView.getModel());
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // 视图渲染后调用
        if (ex != null) {
            System.out.println("ExampleInterceptor: 请求处理完成，发生异常: " + ex.getMessage());
        } else {
            System.out.println("ExampleInterceptor: 请求处理完成，未发生异常.");
        }
        System.out.println("ExampleInterceptor: 响应状态码: " + response.getStatus());
    }
}
