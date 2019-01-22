package pl.szbd.virtualuniversity.domain.commons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.szbd.virtualuniversity.domain.commons.model.entities.StudySubject;

import javax.security.auth.Subject;
import java.util.List;

@Repository
public interface StudySubjectRepository extends JpaRepository<StudySubject, Long> {
    @Query
    public List<StudySubject> findAllByGroupId(Long groupId);

}
