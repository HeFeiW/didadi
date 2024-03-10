package top.fatbird.didadi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import top.fatbird.didadi.dto.ProposalDTO;
import top.fatbird.didadi.mapper.ProposalsMapper;
import top.fatbird.didadi.model.Proposal;
import top.fatbird.didadi.service.ProposalService;

@Controller
public class DetailController {
    @Autowired
    private ProposalService proposalService;
    @GetMapping("/detail/{pid}")
    public String detail(
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
    @GetMapping("/detail")
    public String detail(
    ){
        return "detail";
    }
}
