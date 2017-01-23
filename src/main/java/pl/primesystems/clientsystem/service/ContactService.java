package pl.primesystems.clientsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.primesystems.clientsystem.entity.Contact;
import pl.primesystems.clientsystem.repository.ContactRepository;

import java.util.List;

@Service
@Transactional
public class ContactService {

    private ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> findAllByCustomerId(Long id) {
        return contactRepository.findAllByCustomerId(id);
    }
}
