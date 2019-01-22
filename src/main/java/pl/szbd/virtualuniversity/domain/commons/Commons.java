package pl.szbd.virtualuniversity.domain.commons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.szbd.virtualuniversity.domain.commons.model.Item;
import pl.szbd.virtualuniversity.domain.commons.model.SemesterData;
import pl.szbd.virtualuniversity.domain.commons.model.TableData;
import pl.szbd.virtualuniversity.domain.commons.model.entities.*;
import pl.szbd.virtualuniversity.domain.commons.service.*;
import pl.szbd.virtualuniversity.domain.student.model.Semester;

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
    @Autowired
    private StudySubjectService studySubjectService;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/person/{pesel}", method = RequestMethod.GET)
    private Person getPerson(@PathVariable String pesel) {
        return personService.getPerson(pesel);
    }

    @RequestMapping(value = "/person-by-index/{pesel}", method = RequestMethod.GET)
    private Person getPerson(@PathVariable Long pesel) {
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
    public List<TableData> getProposals(@RequestParam String index, @RequestParam String answer) {
        return proposalService.getProposals(index, answer);
    }

    @GetMapping("/questionnaires/")
    public List<TableData> getProposals(@RequestParam String name) {
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

    @PostMapping(value = "/new-person/", consumes = "application/json")
    public User saveNewPerson(@RequestBody Person person) {
        return personService.saveNewPerson(person);
    }

    @PostMapping(value = "/student/", consumes = "application/json")
    public void saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
    }

    @PostMapping(value = "/address/", consumes = "application/json")
    public void saveAddress(@RequestBody List<Address> address) {
        addressService.saveAddres(address);
    }

    @GetMapping(value = "/get-address/{personId}", produces = "application/json")
    public List<Address> getAddress(@PathVariable String personId) {
        return addressService.getAddres(personId);
    }

    @PostMapping(value = "/contact/", consumes = "application/json")
    public void saveContacts(@RequestBody List<Contact> contacts) {
        contactService.saveContact(contacts);
    }

    @GetMapping(value = "/contact/{personId}", produces = "application/json")
    public List<Contact> getContact(@PathVariable String personId) {
        return contactService.getContact(personId);
    }

    @PostMapping(value = "/grade/", consumes = "application/json")
    public void saveGrade(@RequestBody Grade grade) {
        gradeService.saveGrade(grade);
    }

    @PostMapping(value = "/semester/", consumes = "application/json")
    public void saveGrade(@RequestBody StudentGroup semester) {
        groupService.saveStudentGroup(semester);
    }

    @GetMapping("/student-subjects/{username}")
    public ArrayList<SemesterData> getStudentSubjects(@PathVariable String username, @RequestParam(value = "filter", required = false) String filter) {
        return studentSubjectsService.getStudentSubjects(username, filter);
    }

    @GetMapping("/subjects/{groupId}")
    public List<Item> getSubjectsForSemester(@PathVariable Long groupId) {
        return studySubjectService.findSubjectsForSemester(groupId);
    }

    @GetMapping("/subject/{id}")
    public StudySubject getStudentSubjects(@PathVariable Long id) {
        return studentSubjectsService.getSubject(id);
    }
}
