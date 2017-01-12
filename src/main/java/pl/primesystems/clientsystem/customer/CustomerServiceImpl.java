package pl.primesystems.clientsystem.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
