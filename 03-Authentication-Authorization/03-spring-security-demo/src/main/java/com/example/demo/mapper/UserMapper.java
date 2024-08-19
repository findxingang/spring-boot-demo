package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wangxingang
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
