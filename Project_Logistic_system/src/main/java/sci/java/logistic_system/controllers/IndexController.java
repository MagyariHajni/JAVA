package sci.java.logistic_system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sci.java.logistic_system.Company;

@Controller
public class IndexController {
    private Company company;

    @Autowired
    public void setCompany() {
        this.company = new Company("NoName",4,0);
    }

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("company",company);
        return "index";
    }

}
