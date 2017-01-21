package pl.primesystems.clientsystem.customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/customers")
public class CustomerController {

    private CustomerServiceImpl customerService;
    private CustomerValidator customerValidator;


    /* VALIDATOR */

    @InitBinder
    public void initUserValidator(WebDataBinder binder) {
        binder.addValidators(customerValidator);
    }

    /* CUSTOMER MAPPING */

    @GetMapping
    public String getCustomersList(Model model) {
        System.out.println("wyszukuję customerow");
        List<Customer> customers = customerService.findAll();
        System.out.println("dodaje customerow do widoku");
        model.addAttribute("customers", customers);
        return "customer/customer-list";
    }

    @GetMapping(value = "/add")
    public String getFormAddCustomer() {
        return "customer/customer-add";
    }

    @PostMapping(value = "/add")
    public String addNewCustomer(@Validated Customer customer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute(bindingResult.getAllErrors());
            return "customer/customer-add";
        }
        customerService.add(customer);
        model.addAttribute("customer", customer);
        return "customer/customer-show";
    }

    @GetMapping(value = "/{id}")
    public String showCustomerDetails(@PathVariable Long id, Model model) {
        System.out.println("wyszukuję customera po id");
        Customer customer = customerService.findOne(id);
        System.out.println("dodaje customera do widoku");
        model.addAttribute("customer", customer);
        System.out.println("dodaje phones do widoku");
        model.addAttribute("phones", customer.getPhoneNumbers());
        System.out.println("zwracam widok...");
        return "customer/customer-show";
    }

    @GetMapping(value = "/{id}/edit")
    public String editCustomer(@PathVariable Long id, Model model) {
        Customer customer = customerService.findCustomerById(id);
        model.addAttribute("customer", customer);
        return "customer/customer-edit";
    }

    @GetMapping(value = "/{id}/delete")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }

}
