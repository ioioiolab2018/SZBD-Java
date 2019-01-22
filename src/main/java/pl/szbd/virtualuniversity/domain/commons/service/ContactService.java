package pl.szbd.virtualuniversity.domain.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Address;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Contact;
import pl.szbd.virtualuniversity.domain.commons.repository.AddressRepository;
import pl.szbd.virtualuniversity.domain.commons.repository.ContactRepository;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public void  saveContact(Contact contact){
        contactRepository.save(contact);
    }
    public void  saveContact(List<Contact> contacts){
        System.out.println(contacts);
        contactRepository.save(contacts);
    }
}
