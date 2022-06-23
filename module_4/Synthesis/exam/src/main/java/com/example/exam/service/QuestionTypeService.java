package com.example.exam.service;

import com.example.exam.model.QuestionType;
import com.example.exam.repo.QuestionTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTypeService {
    @Autowired
    private QuestionTypeRepo questionTypeRepo;

    public List<QuestionType> findAll(){
        return questionTypeRepo.findAll();
    }
}
