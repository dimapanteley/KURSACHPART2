package com.example.kurs2.interfaces;

import com.example.kurs2.Qestion;

import java.util.Set;

public interface QuestionService {
    void add(String question, String answer);

    void remove(String question, String answer);

    Set<Qestion> getAll();

    Qestion getRandomQuestion();
}