package top.fatbird.didadi.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.fatbird.didadi.mapper.UserMapper;
import top.fatbird.didadi.model.User;

import java.util.UUID;

@Controller
public class SignupController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/signup")
    public String signup(){
        return "/signup";
    }
    @PostMapping("/signup")
    public String doSignup(
            @RequestParam("account_id") String accountId,
            @RequestParam("password") String password,
            HttpServletRequest request,
            HttpServletResponse response)
    {
        boolean validId;
        if (accountId !=null){
            validId=true;
        }else{validId=false;}
        if (true){
            //有效id，写cookie和session
            User user =new User();
            String token=UUID.randomUUID().toString();
            user.setToken(token);
            user.setName("new_user_"+accountId);
            user.setAccountId(accountId);
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
            response.addCookie(new Cookie("token",token));
            return "/";
        }else{
            //登录失败，重新登录
            return "/";
        }
    }
}
