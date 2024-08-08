package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.domain.UserRole;
import com.example.demo.service.UserRoleService;
import com.example.demo.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author 王新刚
* @description 针对表【t_user_role(用户和角色关系表)】的数据库操作Service实现
* @createDate 2024-08-08 09:28:27
*/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
    implements UserRoleService{

}




