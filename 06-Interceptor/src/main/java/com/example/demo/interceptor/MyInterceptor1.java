package com.example.demo.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wangxingang
 * @since 2024/8/9
 */
public class MyInterceptor1 implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 请求到达 Controller 之前执行
        // 主要用于请求预处理，如权限检查、日志记录、请求参数修改等。
        // 若返回 true，则请求继续处理；若返回 false，请求将被中断，后续的处理步骤（如 postHandle 和 afterCompletion）将不会被调用。
        logger.info("preHandle 1");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 请求处理完毕后，但在视图渲染之前。
        // 可以用来处理在控制器方法执行之后但视图渲染之前的逻辑。例如，修改 ModelAndView 对象、记录日志等。
        logger.info("postHandle 1");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 请求处理完成后，视图渲染完成后。
        // 用于清理资源和记录日志等工作。可以访问请求和响应对象，但此时请求已经完成处理。
        // 可以用来记录请求处理过程中的异常信息（如果有的话），如记录异常栈信息。
        // ex 参数包含了在请求处理过程中发生的异常，如果没有异常，ex 为 null。
        logger.info("afterCompletion 1");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
