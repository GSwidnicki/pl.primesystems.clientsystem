package pl.primesystems.clientsystem.service;

import pl.primesystems.clientsystem.entity.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> findAllByCustomerId(Long id);
}
