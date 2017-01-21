package pl.primesystems.clientsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.primesystems.clientsystem.repository.CustomerRepository;
import pl.primesystems.clientsystem.entity.Customer;
import pl.primesystems.clientsystem.service.CustomerService;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer add(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findCustomerById(Long id) {
        return customerRepository.findOne(id);
    }

    public boolean customerExistsByTaxNumber(Long taxNumber) {
        return customerRepository.findCustomerByTaxNumber(taxNumber).isPresent();
    }

    public void deleteCustomer(Long id) {
        customerRepository.delete(id);
    }

    public Customer findOne(Long id) {
        return customerRepository.findOne(id);
    }
}
