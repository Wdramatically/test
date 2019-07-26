package com.test.hxd.demo.Controller;

import com.test.hxd.demo.dto.AccessTokenDTO;
import com.test.hxd.demo.dto.GithubUser;
import com.test.hxd.demo.mapper.UserMapper;
import com.test.hxd.demo.model.User;
import com.test.hxd.demo.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Author:   86155
 * Date:     2019/7/3 22:51
 */
@Controller
public class AuthorizeContorller {

    @Autowired
    private GithubProvider githubProvider;
    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request,
                            HttpServletResponse response){

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClient_secret(clientSecret);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);

        GithubUser user = githubProvider.getUser(accessToken);

        if(user != null){
            User user1 = new User();
            user1.setAccountId(String.valueOf(user.getId()));
            user1.setName(user.getName());
            String token = UUID.randomUUID().toString();
            user1.setToken(token);
            user1.setGmtCreate(System.currentTimeMillis());
            user1.setGmtModified(user1.getGmtCreate());
            user1.setBio(user.getBio());
            user1.setAvatarUrl(user.getAvatarUrl());
            userMapper.insert(user1);
            response.addCookie(new Cookie("token",token));
            //登录成功，写cookie
            request.getSession().setAttribute("user", user);
            return "redirect:/";
        }else{
            //登陆失败
            return "redirect:/";
        }
    }
}
