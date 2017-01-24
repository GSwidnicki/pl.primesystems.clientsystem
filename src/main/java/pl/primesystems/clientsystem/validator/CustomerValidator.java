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

    private final CustomerService customerService;

    @Autowired
    public CustomerValidator(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;
        checkTaxNumber(customer, errors);
    }

    private void checkTaxNumber(Customer customer, Errors errors) {
        if(customer.getTaxNumber().length() != 10) {
            errors.rejectValue("taxNumber", CHECK_TAX_NUMBER_LENGTH);
        } else if(!isEmpty(customer.getTaxNumber()) && customerService.customerExistsByTaxNumber(customer.getTaxNumber())) {
            errors.reject(CUSTOMER_ALREADY_EXISTS);
        } else {
            byte[] taxNumberTable = new byte[10];
            for (int i=0; i<10; i++) {
                taxNumberTable[i] = Byte.parseByte(customer.getTaxNumber().substring(i, i+1));
            }
            if(!checkSum(taxNumberTable)) {
                errors.reject(TAX_NUMBER_IS_INVALID);
            }
        }
    }

    private boolean checkSum(byte[] taxNumberTable) {
        int sum = 0;
        byte[] weight = {6,5,7,2,3,4,5,6,7};
        for (int i=0; i<9; i++) {
            sum = sum + (taxNumberTable[i]*weight[i]);
        }
        sum %= 11;
        return taxNumberTable[9] == sum;
    }
}
