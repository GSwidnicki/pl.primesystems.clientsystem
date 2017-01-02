package pl.primesystems.clientsystem.phone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/customers/{id}/phones")
public class PhoneController {

    private PhoneServiceImpl phoneService;

    @Autowired
    public PhoneController(PhoneServiceImpl phoneService) {
        this.phoneService = phoneService;
    }

    @PostMapping
    public String addNewPhone(@PathVariable Long id, Phone phone, Model model) {
        phoneService.add(phone);
        return null;
        //TODO
    }
}
