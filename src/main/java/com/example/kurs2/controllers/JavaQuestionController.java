package com.example.kurs2.controllers;

import com.example.kurs2.interfaces.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping()
    public String getAll() {
        return questionService.getAll().toString();
    }

    @GetMapping("/add")
    public String add(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        questionService.add(question, answer);
        return "\n" +
                question + "\n" +
                answer + "\n";
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        questionService.remove(question, answer);
        return " \n" +
                question + "\n" +
                answer + "\n";
    }
}