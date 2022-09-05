package com.example.homeworktwo.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Getter
public class QuestionReader {

    @Autowired
    private LanguageChooser languageChooser;

    private final String resourcePath;
    private List<List<String>> records;

    private final static String CORRECT_ANSWER_PATTERN = " - the correct answer";

    public QuestionReader(String resource) {
        this.resourcePath = resource;
    }

    @PostConstruct
    public void readQuestion() {
        records = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new ClassPathResource(resourcePath).getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(languageChooser.getLocale().getLanguage())) {
                    String[] values = line.split(",");
                    records.add(new ArrayList<>(Arrays.asList(values)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<String> getPatternedElements() {
        List<String> correctAnswers = new ArrayList<>();
        records.forEach(record -> record.forEach(s -> {
            if (s.contains(CORRECT_ANSWER_PATTERN)) {
                correctAnswers.add(s.replace(CORRECT_ANSWER_PATTERN, ""));
                record.set(record.indexOf(s), s.replace(CORRECT_ANSWER_PATTERN, ""));
            }
        }));
        return correctAnswers;
    }

    public String getFormattedOutput(List<String> list) {
        list.remove(languageChooser.getLocale().getLanguage());
        StringBuilder builder = new StringBuilder();
        list.forEach(s -> builder.append(s).append(", "));
        builder.deleteCharAt(builder.lastIndexOf(", ")).deleteCharAt(builder.indexOf(", "));
        return builder.toString();
    }
}
