package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.domain.Role;
import com.example.demo.service.RoleService;
import com.example.demo.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author 王新刚
* @description 针对表【t_role(角色表)】的数据库操作Service实现
* @createDate 2024-08-08 09:28:27
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




