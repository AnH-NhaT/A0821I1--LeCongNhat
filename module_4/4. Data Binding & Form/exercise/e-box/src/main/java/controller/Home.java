package controller;

import model.Info;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class Home {
    @GetMapping
    public String home() {
        return "index";
    }
    public String update(@ModelAttribute Info info){

        return "index";
    }
}
