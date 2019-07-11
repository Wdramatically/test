package com.test.hxd.demo.dto;

/**
 * Author:   86155
 * Date:     2019/7/9 23:21
 */
public class GithubUser {
    private String name;
    private long id;
    private String bio;

    @Override
    public String toString() {
        return "com.test.hxd.demo.dto.GithubUser{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", bio='" + bio + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
