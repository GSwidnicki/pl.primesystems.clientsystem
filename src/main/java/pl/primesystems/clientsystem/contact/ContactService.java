package pl.primesystems.clientsystem.contact;

import java.util.List;

public interface ContactService {
    List<Contact> findAllByCustomerId(Long id);
}
