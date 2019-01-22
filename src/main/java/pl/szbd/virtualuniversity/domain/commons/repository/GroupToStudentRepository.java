package pl.szbd.virtualuniversity.domain.commons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.szbd.virtualuniversity.domain.commons.model.entities.GroupToStudent;

@Repository
public interface GroupToStudentRepository extends JpaRepository<GroupToStudent, Long> {

}
