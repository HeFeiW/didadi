package top.fatbird.didadi.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.fatbird.didadi.enumeration.Sex;
import top.fatbird.didadi.mapper.UserMapper;
import top.fatbird.didadi.model.User;

@Controller
public class ProfileController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/profile")
    public String signup(){
        return "/profile";
    }
    @PostMapping("/profile")
    public String doSignup(
            @RequestParam("name") String name,
            @RequestParam("avatar_url") String avatarUrl,
            @RequestParam("sex") Integer sex,
            HttpServletRequest request,
            HttpServletResponse response
    )
    {
        Cookie[] cookies=request.getCookies();
        if(cookies !=null && cookies.length != 0)
            for (Cookie cookie : cookies){
                if(cookie.getName().equals("token")){
                    String token=cookie.getValue();
                    User user=userMapper.findByToken(token);
                    user.setSex(sex);
                    user.setName(name);
                    user.setGmtModified(System.currentTimeMillis());
                    userMapper.update(user);
                    break;
                }
            }
        return "redirect:/";

    }
}