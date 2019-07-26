package com.test.hxd.demo.Controller;

import com.test.hxd.demo.mapper.UserMapper;
import com.test.hxd.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


/**
 * Author:   86155
 * Date:     2019/7/12 23:26
 */
@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
                    if (cookies != null && cookies.length !=0){
                        for (Cookie cookie : cookies) {
                            if (cookie.getName().equals("token")){
                                String token = cookie.getValue();
                                User user = userMapper.findByToken(token);
                                if (user != null) {
                                    request.getSession().setAttribute("user", user);
                                }
                                break;
                }
            }
    }
        return "index";
    }
}
