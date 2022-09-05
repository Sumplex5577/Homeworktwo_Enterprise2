package com.example.homeworktwo.service;

import com.example.homeworktwo.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Scanner;

public class QuizService {
    @Autowired
    private QuestionReader questionReader;
    @Autowired
    private LanguageChooser languageChooser;
    @Autowired
    private Student student;
    private int points;

    public void logicQuiz() {
        checkStudent();
        List<String> answers = questionReader.getPatternedElements();
        questionReader.getRecords().forEach(
                record -> askQuestion(record, answers.get(questionReader.getRecords().indexOf(record))));
        System.out.println(student.getName() + " " + student.getSurname()
                + " " + languageChooser.getBundle().getString("points")
                + points + "/" + questionReader.getRecords().size());

    }

    private void checkStudent() {
        if (student.getName() == null || student.getSurname() == null) {
            throw new IllegalArgumentException(languageChooser.getBundle().getString("registrationFail"));
        }
    }

        private void askQuestion(List<String> question, String rightAnswer) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(languageChooser.getBundle().getString("chooseAnswer"));
            System.out.println(questionReader.getFormattedOutput(question));
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase(rightAnswer)) {
                points++;
                System.out.println(languageChooser.getBundle().getString("correctAnswer") + "\n");
            } else {
                System.out.println(languageChooser.getBundle().getString("wrongAnswer") + "\n");
            }
        }
    }

