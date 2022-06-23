package com.example.exam.repo;

import com.example.exam.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionContentRepo extends JpaRepository<QuestionContent, Long> {
    @Query(value = "SELECT * FROM question_content WHERE title LIKE %:title% AND question_type_id LIKE %:question_type_id%", nativeQuery = true)
    List<QuestionContent> search(String title, String question_type_id);
}
