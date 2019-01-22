package pl.szbd.virtualuniversity.domain.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Address;
import pl.szbd.virtualuniversity.domain.commons.repository.AddressRepository;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public void saveAddres(Address address) {
        addressRepository.save(address);
    }

    public void saveAddres(List<Address> address) {
        addressRepository.save(address);
    }

    public List<Address> getAddres(String personId) {
        return addressRepository.findAllByPersonId(personId);
    }
}
