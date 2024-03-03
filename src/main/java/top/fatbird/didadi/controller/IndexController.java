package top.fatbird.didadi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.fatbird.didadi.mapper.UserMapper;


@Controller

public class IndexController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/")
    public String index(@RequestParam(name="name",required = false,defaultValue = "World") String name, Model model){
        model.addAttribute("name",name);return"index";
    }
}
