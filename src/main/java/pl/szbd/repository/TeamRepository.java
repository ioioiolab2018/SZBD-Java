package pl.szbd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.szbd.entity.Team;


@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {

	Team findByStudents(long playerId);
}
