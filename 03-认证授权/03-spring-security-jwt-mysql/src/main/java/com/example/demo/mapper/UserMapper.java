package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;
import java.util.Set;

/**
* @author 王新刚
* @description 针对表【t_user(用户表)】的数据库操作Mapper
* @createDate 2024-08-08 09:28:27
* @Entity com.example.demo.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

    Optional<User> selectByUsernameOrEmail(@Param("username") String username, @Param("email") String email);

    // 自定义方法以根据用户ID查询角色
    Set<Role> selectRolesByUserId(@Param("userId") Long userId);
}




