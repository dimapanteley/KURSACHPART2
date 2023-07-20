package com.example.kurs2;


import java.util.HashSet;
import java.util.Set;

public class TestingDataStorage {
    public static final Qestion QUESTION1 = new Qestion(" вопрос 1", " ответ 1");
    public static final Qestion QUESTION2 = new Qestion(" вопрос 2", " ответ2");
    public static final Qestion QUESTION3 = new Qestion(" вопрос 3", " ответ 3");
    public static final Qestion QUESTION4 = new Qestion(" вопрос 4", " ответ 4");
    public static final Qestion QUESTION5 = new Qestion(" вопрос 5 ", "ответ 5");
    public static final Set EMPTY_SET = new HashSet<>();

    public static final Set FULL_SET = new HashSet<>(Set.of(
            new Qestion(QUESTION1.getQuestion(), QUESTION1.getAnswer()),
            new Qestion(QUESTION2.getQuestion(), QUESTION2.getAnswer()),
            new Qestion(QUESTION3.getQuestion(), QUESTION3.getAnswer()),
            new Qestion(QUESTION4.getQuestion(), QUESTION4.getAnswer()),
            new Qestion(QUESTION5.getQuestion(), QUESTION5.getAnswer())
    ));


}