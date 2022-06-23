package controller;

import model.Word;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.WordService;

import java.util.List;

@Controller
public class HomeServlet {
    WordService wordService=new WordService();
    @GetMapping()
    public String find() {
        return "index";
    }

    @PostMapping("/finding")
    public String find(@RequestParam String findword,
                       Model model) {
        List<Word> wordList=wordService.getWordList();
        String result = "";
        for (int i = 0; i < wordList.size(); i++) {
           if (wordList.get(i).getWord().equals(findword)){
               result=wordList.get(i).getNghia();
           }
        }
        model.addAttribute("result",result);
        return "index";
    }
}
