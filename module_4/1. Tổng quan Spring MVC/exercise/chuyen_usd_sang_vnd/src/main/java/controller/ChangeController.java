package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangeController {
    @GetMapping()
    public String changing(){
        return "index";
    }
    @PostMapping("/changing")
    public String changing(@RequestParam int usd, Model model) {
        int vnd = usd * 23000;
        model.addAttribute("vnd", vnd);
        return "index";
    }
}
