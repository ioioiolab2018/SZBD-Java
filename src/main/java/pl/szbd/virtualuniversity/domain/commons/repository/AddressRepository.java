package pl.szbd.virtualuniversity.domain.commons.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Address;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

    @Query
    List<Address> findAllByPersonId(String personId);
}
