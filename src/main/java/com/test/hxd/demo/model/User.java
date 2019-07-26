package com.test.hxd.demo.model;

import lombok.Data;

/**
 * Author:   86155
 * Date:     2019/7/11 22:25
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String bio;
    private String avatarUrl;
}
