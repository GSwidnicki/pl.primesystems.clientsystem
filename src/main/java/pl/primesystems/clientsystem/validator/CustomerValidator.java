package pl.primesystems.clientsystem.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.primesystems.clientsystem.entity.Customer;
import pl.primesystems.clientsystem.service.CustomerService;

import static org.springframework.util.ObjectUtils.isEmpty;
import static pl.primesystems.clientsystem.config.Keys.*;

@Component
public class CustomerValidator implements Validator {

    @Autowired
    private CustomerService customerService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;
        checkTaxNumber(customer, errors);
    }

    public void checkTaxNumber(Customer customer, Errors errors) {
        if(!isEmpty(customer.getTaxNumber()) && customerService.customerExistsByTaxNumber(customer.getTaxNumber())) {
            errors.reject(CUSTOMER_ALREADY_EXISTS);
        }
        if(customer.getTaxNumber().toString().length() != 10) {
            errors.rejectValue("taxNumber", CHECK_TAX_NUMBER_LENGTH);
        }
        //TODO
    }
}
