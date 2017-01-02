package pl.primesystems.clientsystem;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping(value = "/")
    public String getHomePage() {
        return "redirect:/login";
    }

}
