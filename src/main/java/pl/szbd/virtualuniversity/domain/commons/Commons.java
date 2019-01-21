package pl.szbd.virtualuniversity.domain.commons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.szbd.virtualuniversity.domain.commons.model.SemesterData;
import pl.szbd.virtualuniversity.domain.commons.model.TableData;
import pl.szbd.virtualuniversity.domain.commons.model.entities.*;
import pl.szbd.virtualuniversity.domain.commons.service.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/commons")
public class Commons {
    private static final Logger logger = LoggerFactory.getLogger(Commons.class);

    @Autowired
    private PersonService personService;
    @Autowired
    private ProposalService proposalService;
    @Autowired
    private StudentSubjectsService studentSubjectsService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private QuestionnaireMainService questionnaireMainService;

    @RequestMapping(value = "/person/{pesel}", method = RequestMethod.GET)
    private Person getPerson(@PathVariable String pesel) {
        return personService.getPerson(pesel);
    }

    @GetMapping("/proposals/{username}")
    public List<TableData> getStudentProposals(@PathVariable String username) {
        return proposalService.getProposals(username);
    }

    @GetMapping("/proposal/{id}")
    public Proposal getProposal(@PathVariable Long id) {
        return proposalService.getProposalById(id);
    }

    @GetMapping("/proposals/")
    public List<TableData> getProposals(@RequestParam Long surname, @RequestParam String answer ) {
        return proposalService.getProposals(surname, answer);
    }

    @GetMapping("/questionnaires/")
    public List<TableData> getProposals(@RequestParam String name ) {
        System.out.println(questionnaireMainService.getQuestionnairesLike(name));
        return questionnaireMainService.getQuestionnairesLike(name);
    }

    //zapis wniosku z widoku studenta
       @PostMapping(value = "/proposal/", consumes = "application/json")
    public void saveStudentProposal(@RequestBody Proposal proposal) {
        proposalService.saveStudentProposal(proposal);
    }

    // Zapis normalnego wniosku
    @PostMapping(value = "/saveProposal/", consumes = "application/json")
    public void saveProposal(@RequestBody Proposal proposal) {
        proposalService.saveProposal(proposal);
    }

    @PostMapping(value = "/person/", consumes = "application/json")
    public void savePerson(@RequestBody Person person) {
        personService.savePerson(person);
    }

    @PostMapping(value = "/student/", consumes = "application/json")
    public void saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
    }

    @PostMapping(value = "/address/", consumes = "application/json")
    public void saveAddress(@RequestBody Address address) {
        addressService.saveAddres(address);
    }


    @GetMapping("/student-subjects/{username}")
    public ArrayList<SemesterData> getStudentSubjects(@PathVariable String username, @RequestParam(value = "filter", required = false) String filter) {
        return studentSubjectsService.getStudentSubjects(username, filter);
    }

    @GetMapping("/subject/{id}")
    public StudySubject getStudentSubjects(@PathVariable Long id) {
        return studentSubjectsService.getSubject(id);
    }
}
