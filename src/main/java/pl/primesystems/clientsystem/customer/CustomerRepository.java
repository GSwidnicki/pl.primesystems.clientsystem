package pl.primesystems.clientsystem.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT DISTINCT c FROM Customer c JOIN c.phoneNumbers WHERE c.id = :id")
    Customer findOne(Long id);

    Optional<Customer> findCustomerByTaxNumber(Long taxNumber);
}
