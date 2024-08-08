package com.example.demo.mapper;

import com.example.demo.domain.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 王新刚
* @description 针对表【t_user_role(用户和角色关系表)】的数据库操作Mapper
* @createDate 2024-08-08 09:28:27
* @Entity com.example.demo.domain.UserRole
*/
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {

}




