package com.example.homeworktwo.service;

import com.example.homeworktwo.Student;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
public class NameChecker {

    @Autowired
    private Student student;
    @Autowired
    private LanguageChooser languageChooser;

    public void typeNameAndSurname() {


        Scanner scanner = new Scanner(System.in);
        System.out.println(languageChooser.getBundle().getString("name"));
        student.setName(scanner.nextLine());
        checkAnswer(student.getName());


        System.out.println(languageChooser.getBundle().getString("surname"));
        student.setSurname(scanner.nextLine());
        checkAnswer(student.getSurname());
    }



//    private void checkAnswer(String string) {
//        Pattern pattern = Pattern.compile("\\d+");
//        Matcher matcher = pattern.matcher(string);
//        if (string.equals("") || matcher.lookingAt()) {
//            throw new IllegalArgumentException(languageChooser.getBundle().getString("wrongInfo"));
//        }

        private void checkAnswer(String string) {
            if (student.getName().isEmpty() || student.getSurname().isEmpty()) {
                throw new IllegalArgumentException(languageChooser.getBundle().getString("Sorry, the field cannot be empty"));
            }
        }
    }
//}
