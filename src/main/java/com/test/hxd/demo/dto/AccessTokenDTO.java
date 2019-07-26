package com.test.hxd.demo.dto;


import lombok.Data;

/**
 * Author:   86155
 * Date:     2019/7/9 22:41
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
