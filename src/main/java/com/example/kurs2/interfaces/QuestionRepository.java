package com.example.kurs2.interfaces;

import com.example.kurs2.Qestion;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface QuestionRepository {
    Qestion add(String question, String answer);

    Qestion remove(String question, String answer);

    Set<Qestion> getAll();
}