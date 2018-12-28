package pl.szbd.virtualuniversity.domain.commons.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.szbd.virtualuniversity.domain.commons.model.entities.StudySubject;

@Repository
public interface StudySubjectRepository extends CrudRepository<StudySubject, Long> {

}
