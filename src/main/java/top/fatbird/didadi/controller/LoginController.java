package top.fatbird.didadi.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.fatbird.didadi.mapper.UserMapper;
import top.fatbird.didadi.model.User;


@Controller
public class LoginController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/login")
    public  String login(){
        return "/login";
    }
    @PostMapping("/login")
    public String doLogin(
            @RequestParam("user_id") String userId,
            @RequestParam("password") String password,
            HttpServletResponse response,
            Model model

    ){
        User user=userMapper.findByAccountId(userId);
        if (user != null){
           if(password.equals(user.getPassword())){
               response.addCookie(new Cookie("token",user.getToken()));
               return "redirect:/";
           }else{
               model.addAttribute("error","错误的密码或用户ID，请重试");
           }
        }
        return "/login";
    }
}
