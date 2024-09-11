package com.example.demo.web;

import com.example.demo.domain.CustomUser;
import com.example.demo.service.CustomUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangxingang
 */
@Api(value = "测试控制器", tags = "测试API")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    public CustomUserService customUserService;

    @GetMapping("/list")
    public List<CustomUser> getList(){
        return customUserService.list();
    }

    @ApiOperation("添加用户")
    @PostMapping("/add")
    public void add(@RequestBody CustomUser customUser){
        customUserService.saveUserDetails(customUser);
    }
}
