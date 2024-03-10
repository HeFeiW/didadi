package top.fatbird.didadi.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.fatbird.didadi.mapper.ProposalsMapper;
import top.fatbird.didadi.mapper.UserMapper;
import top.fatbird.didadi.model.Proposal;
import top.fatbird.didadi.model.User;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ProposeController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ProposalsMapper proposalsMapper;
    @GetMapping("/propose")
    public  String propose(){
        return "/propose";
    }
    @PostMapping("/propose")
    public  String doPropose(
            @RequestParam(value = "title",required = false) String title,
            @RequestParam(value = "description",required = false) String description,
            @RequestParam(value = "tag",required = false) String tag,
            @RequestParam(value = "expect_time",required = false) String expectTime,
            @RequestParam(value = "expect_number",required = false) Integer expectNumber,
            @RequestParam(value = "location",required = false) String location,
            HttpServletRequest request,
            Model model
    )
    {
        User user=null;
        Cookie[] cookies=request.getCookies();
        if(cookies !=null && cookies.length != 0)
            for (Cookie cookie : cookies){
                if(cookie.getName().equals("token")){
                    String token =cookie.getValue();
                    user=userMapper.findByToken(token);
                    if(user != null){
                        request.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }
        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);
        model.addAttribute("location",location);
        model.addAttribute("expectTime",expectTime);
        model.addAttribute("expectNumber",expectNumber);

        if (user==null){
            model.addAttribute("error","用户未登录");
            return "/signup";
        }
        if (title == null || title == ""){
            model.addAttribute("error","标题不能为空");
            return "/propose";
        }

        DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        Proposal proposal =new Proposal();
        proposal.setTitle(title);
        proposal.setDescription(description);
        proposal.setTag(tag);
        try {
            proposal.setExpectTime(dateFormat.parse(expectTime));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        proposal.setExpectNumber(expectNumber);
        proposal.setLocation(location);
        proposal.setCreator(user.getId());
        proposal.setGmtCreate(System.currentTimeMillis());
        proposal.setGmtModified(proposal.getGmtCreate());
        proposal.setRecruitedNumber(0);
        proposalsMapper.create(proposal);
        return "redirect:/";
    }
}
