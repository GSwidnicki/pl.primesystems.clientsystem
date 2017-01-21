package pl.primesystems.clientsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.primesystems.clientsystem.entity.Customer;
import pl.primesystems.clientsystem.service.impl.CustomerServiceImpl;
import pl.primesystems.clientsystem.validator.CustomerValidator;

import java.util.List;

@Controller
@RequestMapping(value = "/customers")
public class CustomerController {

    private CustomerServiceImpl customerService;
    private CustomerValidator customerValidator;

    @Autowired
    public CustomerController(CustomerServiceImpl customerService, CustomerValidator customerValidator) {
        this.customerService = customerService;
        this.customerValidator = customerValidator;
    }

    /* VALIDATOR */

    @InitBinder
    public void initUserValidator(WebDataBinder binder) {
        binder.addValidators(customerValidator);
    }

    /* CUSTOMER MAPPING */

    @GetMapping
    public String getCustomersList(Model model) {
        List<Customer> customers = customerService.findAll();
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
        Customer customer = customerService.findOne(id);
        model.addAttribute("customer", customer);
        model.addAttribute("phones", customer.getPhoneNumbers());
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
