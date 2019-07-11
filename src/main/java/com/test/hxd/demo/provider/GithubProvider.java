package com.test.hxd.demo.provider;

import com.alibaba.fastjson.JSON;
import com.test.hxd.demo.dto.AccessTokenDTO;
import com.test.hxd.demo.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Author:   86155
 * Date:     2019/7/3 22:58
 */
@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO){
   MediaType mdiaType = MediaType.get("application/json; charset=utf-8");
    OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mdiaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String[] split = string.split("&");
            String tokenstr = split[0];
            String token = tokenstr.split("=")[1];
            return token;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
           GithubUser githubUser = JSON.parseObject(string ,GithubUser.class);
           return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
