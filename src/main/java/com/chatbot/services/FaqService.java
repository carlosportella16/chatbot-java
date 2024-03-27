package com.chatbot.services;

import com.chatbot.domain.FaqAnswer;
import com.chatbot.utils.FaqAnswers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaqService {
    final private FaqAnswers faqAnswers = new FaqAnswers();

    public String getAnswer(String question) {
        List<String> words = List.of(question.toLowerCase().split("\\s+"));
        for (FaqAnswer entry : faqAnswers.getAnswers()) {
            for (String keyword : entry.getKeywords()) {
                if (words.contains(keyword)) {
                    return entry.getAnswer();
                }
            }
        }
        return faqAnswers.getDefaultAnswer();
    }
}
