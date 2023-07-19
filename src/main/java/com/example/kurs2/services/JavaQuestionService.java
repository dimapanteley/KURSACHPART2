package com.example.kurs2.services;

import com.example.kurs2.exceptions.NullCollectionException;
import com.example.kurs2.Qestion;
import com.example.kurs2.exceptions.ParameterIsNullException;
import com.example.kurs2.interfaces.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class JavaQuestionService implements QuestionService {
    private Set<Qestion> questions = new HashSet<>(Set.of(
            new Qestion("вопрос 1", "ответ 1"),
            new Qestion("вопрос 2", "ответ 2"),
            new Qestion("вопрос 3", "ответ 3"),
            new Qestion("вопрос 4", "ответ 4"),
            new Qestion("вопрос 5", "ответ 5"),
            new Qestion("вопрос 6", "ответ 6")
    ));

    @Override
    public void add(String question, String answer) {
        validateParameter(question);
        validateParameter(answer);
        questions.add(new Qestion(question, answer));
        System.out.println("объект Question добавлен\n" +
                question + "\n" +
                answer + "\n");
    }

    @Override
    public void remove(String question, String answer) {
        validateParameter(question);
        validateParameter(answer);
        Qestion questionNeedRemove = new Qestion(question, answer);
        questions.remove(questionNeedRemove);
        System.out.println("объект Question удален\n" +
                question + "\n" +
                answer + "\n");
    }

    @Override
    public Set<Qestion> getAll() {
        for(Qestion question: questions){
            System.out.println(question);
        }
        return questions;
    }

    @Override
    public Qestion getRandomQuestion() {
        validateCollectionIsNotNull();
        int size = questions.size();
        int item = new Random().nextInt(size);
        int i = 0;
        Qestion rez = null;
        for (Qestion element : questions) {
            if (i == item) {
                rez = element;
            }
            i++;
        }
        return rez;
    }

    private void validateCollectionIsNotNull() {
        if (questions.isEmpty()) {
            throw new NullCollectionException(" пусто");
        }
    }

    private void validateParameter(String parameter){
        if(parameter.equals("")){
            throw new ParameterIsNullException(" не ввел запрос");
        }
    }
}