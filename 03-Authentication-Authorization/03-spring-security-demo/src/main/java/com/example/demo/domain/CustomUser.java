package com.example.demo.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

/**
 * @author wangxingang
 */
@Data
public class CustomUser {

    @TableId
    private Integer id;

    /* 用户名 */
    private String username;

    /* 密码 */
    private String password;

    /* 用户已启用 */
    private Boolean enabled;

    /* 帐户尚未过期 */
    private Boolean accountNonExpired;

    /* 帐户未被锁定 */
    private Boolean accountNonLocked;

    /* 凭证尚未过期 */
    private Boolean credentialsNonExpired;

    /* 权限 */
    Set<GrantedAuthority> authorities;
}
