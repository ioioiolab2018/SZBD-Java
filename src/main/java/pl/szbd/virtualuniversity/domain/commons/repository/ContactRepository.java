package pl.szbd.virtualuniversity.domain.commons.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Contact;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {

    @Query
    List<Contact> findAllByPersonId(String personId);
}
