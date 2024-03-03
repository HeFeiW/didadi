package top.fatbird.didadi.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.fatbird.didadi.mapper.ProposalsMapper;
import top.fatbird.didadi.mapper.UserMapper;
import top.fatbird.didadi.model.Proposal;

import java.util.Date;

@Controller
public class ProposeController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ProposalsMapper proposalsMapper;
    @GetMapping("/propose")
    public  String propose(){
        return "propose";
    }
    @PostMapping("/propose")
    public  String doPropose(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("tag") String tag,
            @RequestParam("expect_time") Date expectTime,
            @RequestParam("expect_number") Integer expectNumber,
            @RequestParam("location") String location,
            HttpServletRequest request
    ){
        Proposal proposal =new Proposal();
        proposal.setTitle(title);
        proposal.setDescription(description);
        proposal.setTag(tag);
        proposal.setExpectTime(expectTime);
        proposal.setExpectNumber(expectNumber);
        proposal.setLocation(location);
        /*Cookie[] cookies=request.getCookies();
        for (Cookie cookie : cookies){
            if(cookie.getName().equals("token")){
                String token =cookie.getValue();
                User user=userMapper.findByToken(token);
                if(user != null){
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }
        */
        proposalsMapper.create(proposal);
        return "propose";
    }
}
