package pl.primesystems.clientsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import pl.primesystems.clientsystem.entity.User;
import pl.primesystems.clientsystem.service.UserService;
import pl.primesystems.clientsystem.validator.UserValidator;

@Controller
public class UserController {

    private UserValidator userValidator;
    private UserService userService;

    @Autowired
    public UserController(UserValidator userValidator, UserService userService) {
        this.userValidator = userValidator;
        this.userService = userService;
    }

    /* VALIDATOR */

    @InitBinder
    public void initUserValidator(WebDataBinder binder) {
        binder.addValidators(userValidator);
    }

    /* LOGIN MAPPING */

    @GetMapping(value = "/login")
    public String getLoginPage() {
        return "auth/login";
    }

    /* REGISTER MAPPING */

    @GetMapping(value = "/register")
    public String getRegisterPage() {
        return "auth/register";
    }

    @PostMapping(value = "/register")
    public String setRegisterUser(@Validated User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute(bindingResult.getAllErrors());
            return "auth/register";
        }
        userService.addUserWithDefaultRole(user);
        return "redirect:/login";
    }
}
