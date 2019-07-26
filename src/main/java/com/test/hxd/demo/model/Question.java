package com.test.hxd.demo.model;

import lombok.Data;

/**
 * Author:   86155
 * Date:     2019/7/24 22:36
 */
@Data
public class Question {

    private Long id;
    private String title;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;
    private String description;

}
