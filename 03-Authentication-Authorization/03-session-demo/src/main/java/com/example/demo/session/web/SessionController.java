package com.example.demo.session.web;

import com.example.demo.doamin.User;
import com.example.demo.session.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author wangxingang
 * @since 2024/8/14
 */
@RestController
public class SessionController {

    @PostMapping("login")
    public String login(@RequestBody User user, HttpSession session) {
        // 判断账号密码是否正确，这一步肯定是要读取数据库中的数据来进行校验的，这里为了模拟就省去了
        if ("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())) {
            // 正确的话就将用户信息存到session中
            session.setAttribute("user", user);
            return "登录成功";
        }

        return "账号或密码错误";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 退出登录就是将用户信息删除
        session.removeAttribute("user");
        return "退出成功";
    }

    // 添加 LoginFilter 之前
    // @GetMapping("api")
    // public String api(HttpSession session) {
    //     // 模拟各种api，访问之前都要检查有没有登录，没有登录就提示用户登录
    //     User user = (User) session.getAttribute("user");
    //     if (user == null) {
    //         return "请先登录";
    //     }
    //     // 如果有登录就调用业务层执行业务逻辑，然后返回数据
    //     return "成功返回数据";
    // }
    //
    // @GetMapping("api2")
    // public String api2(HttpSession session) {
    //     // 模拟各种api，访问之前都要检查有没有登录，没有登录就提示用户登录
    //     User user = (User) session.getAttribute("user");
    //     if (user == null) {
    //         return "请先登录";
    //     }
    //     // 如果有登录就调用业务层执行业务逻辑，然后返回数据
    //     return "成功返回数据";
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
        // 各种业务操作
        userService.doSomething();
        return "api成功返回数据";
    }

}
