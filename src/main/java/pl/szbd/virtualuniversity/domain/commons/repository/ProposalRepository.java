package pl.szbd.virtual.university.domain.commons.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.szbd.virtual.university.domain.commons.model.entities.Proposal;

@Repository
public interface ProposalRepository extends CrudRepository<Proposal, Long> {

}
