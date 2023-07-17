package com.example.kurs2;


import java.util.HashSet;
import java.util.Set;

public class TestingDataStorage {
    public static final Question QUESTION1 = new Question(" вопрос 1", " ответ 1");
    public static final Question QUESTION2 = new Question(" вопрос 2", " ответ2");
    public static final Question QUESTION3 = new Question(" вопрос 3", " ответ 3");
    public static final Question QUESTION4 = new Question(" вопрос 4", " ответ 4");
    public static final Question QUESTION5 = new Question(" вопрос 5 ", "ответ 5");
    public static final Set EMPTY_SET = new HashSet<>();

    public static final Set FULL_SET = new HashSet<>(Set.of(
            new Question(QUESTION1.getQuestion(), QUESTION1.getAnswer()),
            new Question(QUESTION2.getQuestion(), QUESTION2.getAnswer()),
            new Question(QUESTION3.getQuestion(), QUESTION3.getAnswer()),
            new Question(QUESTION4.getQuestion(), QUESTION4.getAnswer()),
            new Question(QUESTION5.getQuestion(), QUESTION5.getAnswer())
    ));


}