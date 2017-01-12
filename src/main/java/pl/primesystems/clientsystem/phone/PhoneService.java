package pl.primesystems.clientsystem.phone;

import java.util.List;

public interface PhoneService {
    List<Phone> findAllByCustomerId(Long id);
}
