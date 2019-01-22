package pl.szbd.virtualuniversity.domain.commons.service;

import antlr.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szbd.virtualuniversity.domain.commons.model.TableData;
import pl.szbd.virtualuniversity.domain.commons.model.entities.*;
import pl.szbd.virtualuniversity.domain.commons.model.enums.RoleType;
import pl.szbd.virtualuniversity.domain.commons.repository.ProposalRepository;
import pl.szbd.virtualuniversity.domain.commons.repository.QuestionnaireAnswerRepository;
import pl.szbd.virtualuniversity.domain.commons.repository.QuestionnaireRepository;
import pl.szbd.virtualuniversity.domain.commons.utils.DateFormatter;

import java.util.ArrayList;
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

    public List<TableData> getProposals(String filter1, String filter) {
        Long index;
        List<Student> students=new ArrayList<>();
        try {
            index = Long.parseLong(filter1);
        }
        catch(NumberFormatException nfe) {
            index=null;
        }
        if(index!=null){
        Student student1;

        try {
            student1 = studentService.getStudentByIndex(index);
            if(student1!=null){
            students.add(student1);}
        } catch (Exception e) {
        }}else {
            String name="";
            String surname="";
            String[] filtrSplited= filter1.split( " ");
            if(filtrSplited.length>1){
                name=filtrSplited[1];
                surname=filtrSplited[0];
            }else
            {
                name="&";
                surname=filter1;
            }
            List<Person> personList= personService.getStudentsLike(name,surname, RoleType.STUDENT);
            for (Person person: personList){
                List<TableData> result=new ArrayList<>();
                Student student=studentService.getStudentByPersonId(person.getPesel());
                String user = person.getName()+" "+person.getSurname()+" "+student.getIndex();
                if (filter.equals("false")) {
                    result.addAll(proposalRepository.getProposalsByPersonId(person.getPesel())
                            .stream().filter(proposal -> proposal.getAnswerDate() == null).map(element -> new TableData(
                                    element.getId(),
                                    element.getTopic(),
                                    user,
                                    DateFormatter.getFormatter().format(element.getSubmissionDate()),
                                    element.getShortAnswer() != null ? element.getShortAnswer() : "")).limit(10)
                            .collect(Collectors.toList()));

                }
                if (filter.equals("true")) {
                    result.addAll(proposalRepository.getProposalsByPersonId(person.getPesel())
                            .stream().filter(proposal -> proposal.getAnswerDate() != null).map(element -> new TableData(
                                    element.getId(),
                                    element.getTopic(),
                                    user,
                                    DateFormatter.getFormatter().format(element.getSubmissionDate()),
                                    element.getShortAnswer() != null ? element.getShortAnswer() : "")).limit(10)
                            .collect(Collectors.toList()));

                }
                return result;

        }}
        if(!students.isEmpty()){
            for (Student student: students){

            List<TableData> result=new ArrayList<>();
            String user = personService.getPerson(student.getPersonId()).getName() + " " + personService.getPerson(student.getPersonId()).getSurname() +" "+ index;
            if (filter.equals("false")) {
                result = proposalRepository.getProposalsByPersonId(student.getPersonId())
                        .stream().filter(proposal -> proposal.getAnswerDate() == null).map(element -> new TableData(
                                element.getId(),
                                element.getTopic(),
                                user,
                                DateFormatter.getFormatter().format(element.getSubmissionDate()),
                                element.getShortAnswer() != null ? element.getShortAnswer() : "")).limit(10)
                        .collect(Collectors.toList());
                return result;
            }
            if (filter.equals("true")) {
                result = proposalRepository.getProposalsByPersonId(student.getPersonId())
                        .stream().filter(proposal -> proposal.getAnswerDate() != null).map(element -> new TableData(
                                element.getId(),
                                element.getTopic(),
                                user,
                                DateFormatter.getFormatter().format(element.getSubmissionDate()),
                                element.getShortAnswer() != null ? element.getShortAnswer() : "")).limit(10)
                        .collect(Collectors.toList());
                return result;
            }
        }}
        return null;

    }

    public Proposal getProposalById(Long id) {
        return proposalRepository.getFirstById(id);
    }

    public void saveStudentProposal(Proposal proposal) {
//        User user = userService.getUserByUsername(proposal.getPersonId());
//        proposal.setPersonId(user.getPersonId());
        proposalRepository.save(proposal);
    }
    public void saveProposal(Proposal proposal) {
        proposalRepository.save(proposal);
    }
}
