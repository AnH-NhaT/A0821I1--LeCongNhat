package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Home {
    @GetMapping
    public String Home() {
        return "index";
    }

    @PostMapping("/done")
    public String Compute(@RequestParam String a, @RequestParam String b, @RequestParam String operation, RedirectAttributes redirectAttributes) {
        double res = 0;
        switch (operation) {
            case "*":
                res = Double.parseDouble(a) * Double.parseDouble(b);
                break;
            case "-":
                res = Double.parseDouble(a) - Double.parseDouble(b);
                break;
            case "+":
                res = Double.parseDouble(a) + Double.parseDouble(b);
                break;
            case "/":
                res = Double.parseDouble(a) / Double.parseDouble(b);
                break;
        }
        redirectAttributes.addFlashAttribute("res", res);
        return "redirect:/";
    }
}
