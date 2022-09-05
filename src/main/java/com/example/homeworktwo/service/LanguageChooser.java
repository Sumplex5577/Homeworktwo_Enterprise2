package com.example.homeworktwo.service;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

@Getter
@Setter
public class LanguageChooser {
    private ResourceBundle bundle;

    private Locale locale;


    @PostConstruct
    public void chooseTestLanguage(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose Language (en, esp):");
        String answer = scanner.nextLine();
        locale = new Locale(answer);
        bundle = ResourceBundle.getBundle("language", locale);
    }
}
