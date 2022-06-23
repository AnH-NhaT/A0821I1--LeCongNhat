package com.example.exam.controller;

import com.example.exam.model.QuestionContent;
import com.example.exam.service.QuestionContentService;
import com.example.exam.service.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class mainController {
    @Autowired
    private QuestionContentService questionContentService;
    @Autowired
    private QuestionTypeService questionTypeService;

    private List<QuestionContent> questionContentList;

    @GetMapping
    public String getHome(Model model, String title, String question_type_id) {
        if (title == null || question_type_id == null) {
            title = "";
            question_type_id = "";
        }
        questionContentList = questionContentService.search(title, question_type_id);
        model.addAttribute("questionContentList", questionContentList);
        model.addAttribute("questionTypeList", questionTypeService.findAll());
        model.addAttribute("questionContent", new QuestionContent());
        return "index";
    }

    @PostMapping("/save")
    public String save(Model model, @Valid @ModelAttribute QuestionContent questionContent, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("questionContentList", questionContentService.findAll());
            model.addAttribute("questionTypeList", questionTypeService.findAll());
            return "index";
        }
        questionContentService.save(questionContent);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(Long id) {
        questionContentService.deleteById(id);
        return "redirect:/";
    }

    @ExceptionHandler
    public String exception() {
        return "error";
    }
}
