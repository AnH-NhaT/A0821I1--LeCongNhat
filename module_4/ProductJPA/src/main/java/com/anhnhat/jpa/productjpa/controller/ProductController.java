package com.anhnhat.jpa.productjpa.controller;

import javax.validation.Valid;

import com.anhnhat.jpa.productjpa.model.Product;
import com.anhnhat.jpa.productjpa.service.CategoryService;
import com.anhnhat.jpa.productjpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;


@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    protected String[] arrayDefault = {"1", "2", "3", "4", "5"};
    String toastMessage = "";
    Page<Product> productList;

    @GetMapping
    public String getHome(@PageableDefault(size = 5) Pageable pageable,
                          //
                          @RequestParam(defaultValue = "0") int page,
                          //
                          @RequestParam(defaultValue = "-1") String h, Model model,
                          //
                          @RequestParam(required = false) String[] tempArrayPages,
                          //
                          @RequestParam(defaultValue = "") String sortBy,
                          //
                          @RequestParam(defaultValue = "") String ascOrDesc) {
        model.addAttribute("arrayPages", arrayPageIndex(productService.findAll(pageable).getTotalPages()));
        if (tempArrayPages == null) model.addAttribute("tempArrayPages", arrayDefault);
        else model.addAttribute("tempArrayPages", tempArrayPages);

        if (ascOrDesc.equals("asc")) {
            sortByDescFunc(sortBy, pageable);
            ascOrDesc = "desc";
        } else if (ascOrDesc.equals("desc")) {
            sortByAscFunc(sortBy, pageable);
            ascOrDesc = "asc";
        } else productList = productService.findAll(pageable);

        model.addAttribute("sortBy", sortBy);
        model.addAttribute("ascOrDesc", ascOrDesc);
        model.addAttribute("productList", productList);
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("toastMessage", toastMessage);
        toastMessage = "";
        model.addAttribute("product", new Product());
        model.addAttribute("currentPage", page);
        model.addAttribute("by", "");
        model.addAttribute("h", h);
        return "index";
    }

    @GetMapping("/search")
    public String search(@PageableDefault(size = 5) Pageable pageable,
                         //
                         @RequestParam(defaultValue = "") String by, Model model,
                         //
                         @RequestParam(defaultValue = "") String value,
                         //
                         @RequestParam(defaultValue = "0") int page,
                         //
                         @RequestParam(defaultValue = "0") String h,
                         //
                         @RequestParam(required = false) String[] tempArrayPages,
                         //
                         @RequestParam(defaultValue = "") String sortBy,
                         //
                         @RequestParam(defaultValue = "") String ascOrDesc) {
        switch (by) {
            case "name":
                productList = productService.searchByName(value, pageable);
                model.addAttribute("arrayPages", arrayPageIndex(productService.searchByName(value, pageable).getTotalPages()));
                break;
            case "price":
                productList = productService.searchByPrice(value, pageable);
                model.addAttribute("arrayPages", arrayPageIndex(productService.searchByPrice(value, pageable).getTotalPages()));
                break;
            case "whole":
                productList = productService.searchAllFields(value, pageable);
                model.addAttribute("arrayPages", arrayPageIndex(productService.searchAllFields(value, pageable).getTotalPages()));
                break;
            case "category":
                productList = productService.searchByCategory(value, pageable);
                model.addAttribute("arrayPages", arrayPageIndex(productService.searchByCategory(value, pageable).getTotalPages()));
                break;
            default:
                productList = productService.findAll(pageable);
                model.addAttribute("arrayPages", arrayPageIndex(productService.findAll(pageable).getTotalPages()));
                break;
        }
        model.addAttribute("h", h);
        model.addAttribute("by", by);
        model.addAttribute("value", value);
        model.addAttribute("currentPage", page);
        model.addAttribute("product", new Product());
        if (value.equals("")) {
            if (ascOrDesc.equals("asc")) sortByAscFunc(sortBy, pageable);
            else if (ascOrDesc.equals("desc")) sortByDescFunc(sortBy, pageable);
            else productList = productService.findAll(pageable);
        }
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("ascOrDesc", ascOrDesc);
        model.addAttribute("productList", productList);
        model.addAttribute("categoryList", categoryService.findAll());
        if (tempArrayPages == null) model.addAttribute("tempArrayPages", arrayDefault);
        else model.addAttribute("tempArrayPages", tempArrayPages);
        return "index";
    }

    @PostMapping("/delete")
    public String delete(Long[] id, String currentUrl, RedirectAttributes redirectAttributes) {
        toastMessage = "success";
        productService.deleteById(id);
        redirectAttributes.addFlashAttribute("toastMessage", "success");
        return "redirect:" + currentUrl + "";
    }

    @PostMapping("/save")
    public String save(Model model,// must be adjacent to each other
                       @Valid @ModelAttribute Product product, BindingResult bindingResult,
                       //
                       @PageableDefault(size = 5) Pageable pageable, String currentUrl,
                       //
                       @RequestParam(defaultValue = "0") int page,
                       //
                       RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("currentPage", page);
            model.addAttribute("tempArrayPages", arrayDefault);
            model.addAttribute("categoryList", categoryService.findAll());
            model.addAttribute("productList", productService.findAll(pageable));
            return "index";
        } else {
            String[] arrayP = new String[5];
            int pageArray = (productService.findAll(pageable).getTotalPages() / 5) * 5 - 4;
            int totalPages = productService.findAll(pageable).getTotalPages();
            long totalRecords = productService.findAll(pageable).getTotalElements();
            for (int i = 0; i < 5; i++) arrayP[i] = String.valueOf(pageArray + i);
            if (totalPages > Integer.parseInt(arrayP[4]) || totalRecords == totalPages * 5L)
                for (int i = 0; i < 5; i++) arrayP[i] = String.valueOf(pageArray + i + 5);
            String finalArray = Arrays.toString(arrayP).replaceAll("[ \\[\\]]", "");
            toastMessage = "success";
            if (product.getId() != null) {
                productService.save(product);
                redirectAttributes.addFlashAttribute("toastMessage", "success");
                return "redirect:" + currentUrl;
            } else {
                productService.save(product);
                redirectAttributes.addFlashAttribute("toastMessage", "success");
                return "redirect:http://localhost:8080/search?page=" + (productService.findAll(pageable).getTotalPages() - 1) + "&h=1&tempArrayPages=" + finalArray;
            }
        }
    }

    @ExceptionHandler
    public String exception() {
        return "error";
    }

    public int[] arrayPageIndex(int quantity) {
        int[] result = new int[quantity];
        for (int i = 0; i < quantity; i++) {
            result[i] = i + 1;
        }
        return result;
    }

    public void sortByAscFunc(String switchVar, Pageable pageable) {
        switch (switchVar) {
            case "name":
                productList = productService.sortInAscName(pageable);
                break;
            case "price":
                productList = productService.sortInAscPrice(pageable);
                break;
            case "expiration":
                productList = productService.sortInAscExpiration(pageable);
                break;
            default:
                productList = productService.findAll(pageable);
        }
    }

    public void sortByDescFunc(String switchVar, Pageable pageable) {
        switch (switchVar) {
            case "name":
                productList = productService.sortInDescName(pageable);
                break;
            case "price":
                productList = productService.sortInDescPrice(pageable);
                break;
            case "expiration":
                productList = productService.sortInDescExpiration(pageable);
                break;
            default:
                productList = productService.findAll(pageable);
        }
    }
}