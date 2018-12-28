package pl.szbd.virtualuniversity.domain.commons.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Addres;

@Repository
public interface AddresRepository extends CrudRepository<Addres, Long> {

}
