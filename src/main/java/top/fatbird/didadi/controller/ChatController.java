package top.fatbird.didadi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.fatbird.didadi.dto.ProposalDTO;
import top.fatbird.didadi.mapper.UserMapper;
import top.fatbird.didadi.service.ProposalService;
@Controller
public class ChatController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ProposalService proposalService;
    @GetMapping("/chat/{pid}")
    public String chat(
            @PathVariable(name = "pid",required = false) Integer pid,
            Model model
    ){
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