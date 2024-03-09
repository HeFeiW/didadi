package top.fatbird.didadi.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import top.fatbird.didadi.dto.ProposalDTO;
import top.fatbird.didadi.mapper.UserMapper;
import top.fatbird.didadi.model.User;
import top.fatbird.didadi.service.ProposalService;

import java.util.List;


@Controller

public class IndexController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ProposalService proposalService;
    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model
    )
    {
        Cookie[] cookies=request.getCookies();
        if(cookies !=null && cookies.length != 0)
            for (Cookie cookie : cookies){
            if(cookie.getName().equals("token")){
                String token=cookie.getValue();
                User user=userMapper.findByToken(token);
                if(user != null){
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }

        List<ProposalDTO> proposalList= proposalService.list();
        model.addAttribute("proposals",proposalList);
        return "/index";
    }
}
