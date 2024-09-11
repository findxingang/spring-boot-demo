package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.domain.CustomUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wangxingang
 */
@Mapper
public interface UserMapper extends BaseMapper<CustomUser> {
}
