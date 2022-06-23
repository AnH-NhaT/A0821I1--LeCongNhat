package com.anhnhat.jpa.productjpa.controller;

import javax.validation.Valid;

import com.anhnhat.jpa.productjpa.model.Product;
import com.anhnhat.jpa.productjpa.service.CategoryService;
import com.anhnhat.jpa.productjpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Arrays;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    Page<Product> productList;

    @GetMapping
    public String getHome(String name, String price, String expiration, String category_id, Pageable pageable, Model model) {
        if (name == null || price == null || expiration == null || category_id == null) {
            name = "";
            price = "";
            expiration = "";
            category_id = "";
        }
        productList = productService.search(name, price, expiration, category_id, pageable);
        boolean isASC = false;
        Sort sort = pageable.getSort();
        String f = "", d = "", temp = "";
        if (sort.isSorted()) {
            String[] tmp = sort.toString().toLowerCase().split(":");
            f = tmp[0].trim();
            d = tmp[1].trim();
            isASC = d.equals("asc");
            temp = f + "," + d;
        }

        model.addAttribute("name", name);
        model.addAttribute("price", price);
        model.addAttribute("expiration", expiration);
        model.addAttribute("category_id", category_id);
        model.addAttribute("productList", productList);
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("product", new Product());
        model.addAttribute("sort",temp);
        String revert = isASC ? "desc" : "asc";
        model.addAttribute("reverseSort",revert);
        return "index";
    }

    @PostMapping("/delete")
    public String delete(Long id) {
        productService.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/save")
    public String save(Model model, @Valid @ModelAttribute Product product, BindingResult bindingResult, Pageable pageable) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categoryList", categoryService.findAll());
            model.addAttribute("productList", productService.findAll(pageable));
            return "index";
        }
        productService.save(product);
        return "redirect:/";
    }

    @ExceptionHandler
    public String exception() {
        return "error";
    }

}