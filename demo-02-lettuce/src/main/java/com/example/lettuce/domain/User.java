package com.example.lettuce.domain;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author xingang
 * @since 2024/05/30 9:24
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String age;
    private LocalDateTime birthday;
}
