package com.example.exam.service;

import com.example.exam.model.QuestionContent;
import com.example.exam.repo.QuestionContentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionContentService {
    @Autowired
    private QuestionContentRepo questionContentRepo;

    public List<QuestionContent> findAll() {
        return questionContentRepo.findAll();
    }

    public void save(QuestionContent questionContent) {
        questionContentRepo.save(questionContent);
    }

    public void deleteById(Long id) {
        questionContentRepo.deleteById(id);
    }

    public List<QuestionContent> search(String title, String question_type_id) {
        return questionContentRepo.search(title, question_type_id);
    }
}
