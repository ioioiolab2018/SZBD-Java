package pl.szbd.virtualuniversity.domain.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szbd.virtualuniversity.domain.commons.model.TableData;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Person;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Proposal;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Student;
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
    private StudentService studentService;
    @Autowired
    private UserService userService;
    @Autowired
    private PersonService personService;

    public List<TableData> getProposals(String username) {
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

    public List<TableData> getProposals(Long index, String answer) {
        Student student;
        try {
            student = studentService.getStudentByIndex(index);
        } catch (Exception e) {
            student = null;
        }

        if (student != null) {
            List<TableData> result;
            String user = personService.getPerson(student.getPersonId()).getName() + " " + personService.getPerson(student.getPersonId()).getSurname() +" "+ index;
            if (answer.equals("false")) {
                result = proposalRepository.getProposalsByPersonId(student.getPersonId())
                        .stream().filter(proposal -> proposal.getAnswerDate() == null).map(element -> new TableData(
                                element.getId(),
                                element.getTopic(),
                                user,
                                DateFormatter.getFormatter().format(element.getSubmissionDate()),
                                element.getShortAnswer() != null ? element.getShortAnswer() : ""))
                        .collect(Collectors.toList());
                return result.subList(0, Math.min(9, result.size() - 1));
            }
            if (answer.equals("true")) {
                result = proposalRepository.getProposalsByPersonId(student.getPersonId())
                        .stream().filter(proposal -> proposal.getAnswerDate() != null).map(element -> new TableData(
                                element.getId(),
                                element.getTopic(),
                                user,
                                DateFormatter.getFormatter().format(element.getSubmissionDate()),
                                element.getShortAnswer() != null ? element.getShortAnswer() : ""))
                        .collect(Collectors.toList());
                return result.subList(0, Math.min(9, result.size() - 1));

            }
        }
        return null;
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
