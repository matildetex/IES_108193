package pt.deti.ies.demospring2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    @GetMapping("/greeting") //@GetMapping -> guarantees that HTTP requests to /greeting are mapped to the gretting() method
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) // RequestParam -> binds string parameter name into the name parameter of the greeting() method, if absent returns defaultvalue.
    {
        model.addAttribute("name", name); // name parameter is added to a Model object, ultimately making it accessible to the view template.
        return "greeting";
    }
}