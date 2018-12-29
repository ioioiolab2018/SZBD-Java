package pl.szbd.virtualuniversity.domain.commons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Proposal;

import java.util.List;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Long> {

    @Query(value = "SELECT * FROM PROPOSALS p WHERE p.PERSON_ID = ? ORDER BY p.SUBMISSION_DATE DESC, p.TOPIC ASC", nativeQuery = true)
    List<Proposal> getProposalsByPersonId(String personId);
}
