package pl.primesystems.clientsystem.customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();
    Customer add(Customer customer);
    Customer findCustomerById(Long id);
    boolean customerExistsByTaxNumber(Long taxNumber);
    void deleteCustomer(Long id);
}
