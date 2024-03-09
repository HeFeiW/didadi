package top.fatbird.didadi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.fatbird.didadi.dto.ProposalDTO;
import top.fatbird.didadi.mapper.ProposalsMapper;
import top.fatbird.didadi.mapper.UserMapper;
import top.fatbird.didadi.model.Proposal;
import top.fatbird.didadi.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProposalService {
    @Autowired
    private ProposalsMapper proposalsMapper;
    @Autowired
    private UserMapper userMapper;
    public List<ProposalDTO> list() {
        List<Proposal> proposals = proposalsMapper.list();
        List<ProposalDTO> proposalDTOList = new ArrayList<>();
        for (Proposal proposal : proposals){
            User user = userMapper.findById(proposal.getCreator());
            ProposalDTO proposalDTO = new ProposalDTO();
            BeanUtils.copyProperties(proposal,proposalDTO);
            proposalDTO.setUser(user);
            proposalDTOList.add(proposalDTO);
        }
        return proposalDTOList;
    }
}
