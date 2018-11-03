package pl.szbd.virtual.university.domain.commons.repository;

import org.springframework.data.repository.CrudRepository;
import pl.szbd.virtual.university.domain.commons.model.entities.Proposal;

public interface ProposalRepository extends CrudRepository<Proposal, Long> {

}
