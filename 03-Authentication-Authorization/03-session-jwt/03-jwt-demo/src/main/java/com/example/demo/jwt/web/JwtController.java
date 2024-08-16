package com.example.demo.jwt.web;

import com.example.demo.doamin.User;
import com.example.demo.jwt.service.UserService;
import com.example.demo.jwt.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangxingang
 * @since 2024/8/14
 */
@RestController
public class JwtController {
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        // 判断账号密码是否正确，这一步肯定是要读取数据库中的数据来进行校验的，这里为了模拟就省去了
        if ("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())) {
            // 如果正确的话就返回生成的token（注意哦，这里服务端是没有存储任何东西的）
            return JwtUtil.generate(user.getUsername());
        }
        return "账号密码错误";
    }

    // @GetMapping("api")
    // public String api(HttpServletRequest request) {
    //     // 从请求头中获取token字符串
    //     String jwt = request.getHeader("Authorization");
    //     // 解析失败就提示用户登录
    //     if (JwtUtil.parse(jwt) == null) {
    //         return "请先登录";
    //     }
    //     // 解析成功就执行业务逻辑返回数据
    //     return "Jwt api成功返回数据";
    // }
    //
    // @GetMapping("api2")
    // public String api2(HttpServletRequest request) {
    //     String jwt = request.getHeader("Authorization");
    //     if (JwtUtil.parse(jwt) == null) {
    //         return "请先登录";
    //     }
    //     return "Jwt api2成功返回数据";
    // }

    // @GetMapping("api")
    // public String api() {
    //     return "api成功返回数据";
    // }

    @GetMapping("api2")
    public String api2() {
        return "api2成功返回数据";
    }

    @Autowired
    private UserService userService;

    @GetMapping("api")
    public String api() {
        userService.doSomething();
        return "api成功返回数据";
    }
}