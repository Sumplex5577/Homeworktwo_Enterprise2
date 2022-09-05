package com.example.homeworktwo;

import com.example.homeworktwo.service.LanguageChooser;
import com.example.homeworktwo.service.NameChecker;
import com.example.homeworktwo.service.QuestionReader;
import com.example.homeworktwo.service.QuizService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class QuizConfig {
    private static final String RESOURCE_PATH = "questions.csv";

    @Bean(name = "nameChecker")
    public NameChecker nameChecker() {
        return new NameChecker();
    }

    @Bean(name = "languageChooser")
    public LanguageChooser languageChooser() {
        return new LanguageChooser();
    }

    @Bean(name = "student")
    public Student student() {
        return new Student();
    }

    @Bean(name = "quizService")
    public QuizService quizService() {
        return new QuizService();
    }

    @Bean(name = "questionReader")
    public QuestionReader questionReader() {
        return new QuestionReader(RESOURCE_PATH);
    }
}