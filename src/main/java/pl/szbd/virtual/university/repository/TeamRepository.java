package pl.szbd.virtual.university.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.szbd.virtual.university.entity.Team;


@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {

	Team findByStudents(long playerId);
}
