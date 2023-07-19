package com.example.kurs2;


import com.example.kurs2.exceptions.AmountOutOfCollectionBoundException;
import com.example.kurs2.services.ExaminerServiceImpl;
import com.example.kurs2.services.JavaQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.mockito.Mock;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static com.example.kurs2.TestingDataStorage.*;
import static org.junit.jupiter.api.Assertions.*;


public class ExaminerServiceImplTest {
    private ExaminerServiceImpl examinerService;
    @Mock
    private JavaQuestionService jcs;

    @BeforeEach
    public void setUp() {
        jcs = new JavaQuestionService();
        examinerService = new ExaminerServiceImpl(jcs);

    }

    public static Stream<Arguments> provideParamsForTheTests() {
        return Stream.of(
                Arguments.of(QUESTION1),
                Arguments.of(QUESTION2),
                Arguments.of(QUESTION3),
                Arguments.of(QUESTION4),
                Arguments.of(QUESTION5)
        );
    }


    @Test
    public void getQuestionsTest() {
        List<String> expectedQuestionList = examinerService.getQuestions(4);

        for (int i = 0; i < expectedQuestionList.size(); i++) {
            for (Qestion element : jcs.getAll()) {
                if (expectedQuestionList.get(i).equals(element.getQuestion())) {
                    String expectedQuestion = element.getQuestion();
                    String actualQuestion = expectedQuestionList.get(i);
                    assertEquals(expectedQuestion, actualQuestion);
                }
            }
        }
        Set<String> expectedQuestionSet = new HashSet<>(expectedQuestionList);
        assertEquals(expectedQuestionList.size(), expectedQuestionSet.size());
    }

    @Test
    public void getQuestionsExceptionTest() {
        assertThrows(AmountOutOfCollectionBoundException.class, () -> examinerService.getQuestions(jcs.getAll().size() + 1));
        assertThrows(AmountOutOfCollectionBoundException.class, () -> examinerService.getQuestions(-1));
    }

}