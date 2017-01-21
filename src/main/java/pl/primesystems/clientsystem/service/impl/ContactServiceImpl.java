package pl.primesystems.clientsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.primesystems.clientsystem.entity.Contact;
import pl.primesystems.clientsystem.repository.ContactRepository;
import pl.primesystems.clientsystem.service.ContactService;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> findAllByCustomerId(Long id) {
        return contactRepository.findAllByCustomerId(id);
    }
}
