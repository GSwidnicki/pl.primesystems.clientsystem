package pl.primesystems.clientsystem.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/customers")
public class CustomerRestController {

    private CustomerServiceImpl customerService;
    private CustomerValidator customerValidator;

    @Autowired
    public CustomerRestController(CustomerServiceImpl customerService, CustomerValidator customerValidator) {
        this.customerService = customerService;
        this.customerValidator = customerValidator;
    }

    @GetMapping
    @ResponseBody
    public List<Customer> getCustomersList() {
        List<Customer> customers = customerService.findAll();
        for(Customer customer: customers) {
            System.out.println(customer);
        }
        return customers;
    }
}
