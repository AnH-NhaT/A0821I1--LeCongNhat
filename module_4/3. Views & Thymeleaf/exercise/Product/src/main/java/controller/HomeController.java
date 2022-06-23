package controller;

import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import service.ProductService;
import service.ProductServiceImpl;

@Controller
public class HomeController {
    private ProductService productService = new ProductServiceImpl();

    @GetMapping
    public String getHome(Model model) {
        model.addAttribute("productList", productService.getAll());
        model.addAttribute("product", new Product());
        return "index";
    }

    @PostMapping
    public String save(Model model, Product product) {
        productService.save(product);
        model.addAttribute("productList", productService.getAll());
        return "redirect:/";
    }
}
