package top.fatbird.didadi.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import top.fatbird.didadi.dto.ProposalDTO;
import top.fatbird.didadi.service.ProposalService;

@Controller
public class DetailController {
    @Autowired
    private ProposalService proposalService;
    @GetMapping("/detail/{pid}")
    public String detail(
            @PathVariable("pid") Integer pid,
            Model model
    ){
        ModelAndView modelAndView=new ModelAndView();
        ProposalDTO proposalDTO = null;
        if(pid != null){
            proposalDTO = proposalService.findById(pid);
            model.addAttribute("proposal",proposalDTO);
        }else {
            model.addAttribute("error","页面不存在");
        }

        return "detail";
    }
}
