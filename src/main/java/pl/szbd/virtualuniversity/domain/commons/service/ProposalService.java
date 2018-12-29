package pl.szbd.virtualuniversity.domain.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szbd.virtualuniversity.domain.commons.model.TableData;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Proposal;
import pl.szbd.virtualuniversity.domain.commons.model.entities.User;
import pl.szbd.virtualuniversity.domain.commons.repository.ProposalRepository;
import pl.szbd.virtualuniversity.domain.commons.utils.DateFormatter;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProposalService {
    @Autowired
    private ProposalRepository proposalRepository;
    @Autowired
    private UserService userService;

    public List<TableData> getStudentProposals(String username) {
        User user = userService.getUserByUsername(username);
        return proposalRepository.getProposalsByPersonId(user.getPersonId())
                .stream().map(element -> new TableData(
                        element.getId(),
                        element.getTopic(),
                        DateFormatter.getFormatter().format(element.getSubmissionDate()),
                        element.getAnswerDate() != null ? DateFormatter.getFormatter().format(element.getAnswerDate()) : "",
                        element.getShortAnswer() != null ? element.getShortAnswer() : ""))
                .collect(Collectors.toList());
    }

    public Proposal getProposalById(Long id) {
        return proposalRepository.findOne(id);
    }

    public void saveProposal(Proposal proposal) {
        User user = userService.getUserByUsername(proposal.getPersonId());
        proposal.setPersonId(user.getPersonId());
        proposalRepository.save(proposal);
    }
}
