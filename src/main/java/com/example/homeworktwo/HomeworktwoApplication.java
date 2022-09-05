package com.example.homeworktwo;

import com.example.homeworktwo.service.NameChecker;
import com.example.homeworktwo.service.QuizService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HomeworktwoApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(QuizConfig.class);
        SpringApplication.run(HomeworktwoApplication.class, args);
        NameChecker nameChecker = (NameChecker) context.getBean("nameChecker");
        QuizService quizService = (QuizService) context.getBean("quizService");
        nameChecker.typeNameAndSurname();
        quizService.logicQuiz();
    }

}
