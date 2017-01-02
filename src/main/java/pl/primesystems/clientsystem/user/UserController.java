package pl.primesystems.clientsystem.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private UserValidator userValidator;

    @Autowired
    public UserController(UserValidator userValidator) {
        this.userValidator = userValidator;
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

    @PostMapping(value = "/login")
    public String setLoginUser() {
        //TODO
        return null;
    }

    /* REGISTER MAPPING */

    @GetMapping(value = "/register")
    public String getRegisterPage() {
        return "auth/register";
    }

    @PostMapping(value = "/register")
    public String setRegisterUser(@Validated User user, BindingResult bindingResult, Model model) {
        //TODO
        return null;
    }
}
