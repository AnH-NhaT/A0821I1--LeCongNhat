package com.example.exam.repo;

import com.example.exam.model.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionTypeRepo extends JpaRepository<QuestionType, Long> {
}
