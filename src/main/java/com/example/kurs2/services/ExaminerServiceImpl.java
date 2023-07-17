package com.example.kurs2.services;

import com.example.kurs2.exceptions.AmountOutOfCollectionBoundException;
import com.example.kurs2.interfaces.ExaminerService;
import com.example.kurs2.interfaces.QuestionService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class ExaminerServiceImpl implements ExaminerService {
    private List<String> questionsList = new ArrayList<>();
    private QuestionService questionService;
    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public List<String> getQuestions(int amount) {
        questionsList.clear();
        validateQuantityQuestions(amount);
        int originalQuestionsCounter = 1;
        while (originalQuestionsCounter <= amount) {
            String question = questionService.getRandomQuestion().getQuestion();
            if (isQuestionUnique(question)) {
                questionsList.add(question);
                originalQuestionsCounter++;
            }
        }
        return questionsList;
    }

    private boolean isQuestionUnique(String question) {
        for (String element : questionsList) {
            if (element.equals(question)) {
                return false;
            }
        }
        return true;
    }

    private void validateQuantityQuestions(int amount) {
        if (amount < questionService.getAll().size() || amount > 0) {
            throw new AmountOutOfCollectionBoundException();
        }
    }


}