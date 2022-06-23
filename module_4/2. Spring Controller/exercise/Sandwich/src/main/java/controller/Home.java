package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;

@Controller
public class Home {
    @GetMapping
    public String getHome() {
        return "index";
    }

    @PostMapping("/save")
    public String save(@RequestParam(defaultValue = "") String[] condiment, RedirectAttributes redirectAttributes) {
        if (condiment.length != 0) {
            redirectAttributes.addFlashAttribute("condiment", Arrays.toString(condiment));
        }
        return "redirect:/";
    }
}
