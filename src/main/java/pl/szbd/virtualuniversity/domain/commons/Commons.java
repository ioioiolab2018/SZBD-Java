package pl.szbd.virtualuniversity.domain.commons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.szbd.virtualuniversity.domain.commons.model.TableData;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Person;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Proposal;
import pl.szbd.virtualuniversity.domain.commons.service.PersonService;
import pl.szbd.virtualuniversity.domain.commons.service.ProposalService;

import java.util.List;


@RestController
@RequestMapping("/api/commons")
public class Commons {
    private static final Logger logger = LoggerFactory.getLogger(Commons.class);

    @Autowired
    private PersonService personService;
    @Autowired
    private ProposalService proposalService;

    @RequestMapping(value = "/person/{pesel}", method = RequestMethod.GET)
    private Person getPerson(@PathVariable String pesel) {
        return personService.getPerson(pesel);
    }

    @GetMapping("/proposals/{username}")
    public List<TableData> getStudentProposals(@PathVariable String username) {
        return proposalService.getStudentProposals(username);
    }

    @GetMapping("/proposal/{id}")
    public Proposal getProposal(@PathVariable Long id) {
        return proposalService.getProposalById(id);
    }

    @PostMapping(value = "/proposal/", consumes = "application/json")
    public void savePersonInformation(@RequestBody Proposal proposal) {
        proposalService.saveProposal(proposal);
    }
}
