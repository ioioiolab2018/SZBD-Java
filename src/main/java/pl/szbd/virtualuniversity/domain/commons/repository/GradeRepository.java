package pl.szbd.virtualuniversity.domain.commons.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Grade;
import pl.szbd.virtualuniversity.domain.commons.model.enums.GradeTypeEnum;

@Repository
public interface GradeRepository extends CrudRepository<Grade, Long> {
    @Query
    Grade findFirstByStudentIndexAndStudySubjectIdAndType(Long index, Long subjectId, GradeTypeEnum type);
}
