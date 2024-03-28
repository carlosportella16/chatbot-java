package com.chatbot.services;

import com.chatbot.domain.FaqAnswer;
import com.chatbot.utils.FaqAnswers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class FaqService {
    final private FaqAnswers faqAnswers = new FaqAnswers();

    public String getAnswer(String question) {
        List<String> words = Stream.of(question.toLowerCase().split("\\s+")).map(String::toLowerCase).toList();
        for (FaqAnswer entry : faqAnswers.getAnswers()) {
            for (String keyword : entry.getKeywords()) {
                if (words.contains(keyword.toLowerCase())) {
                    return entry.getAnswer();
                }
            }
        }
        return faqAnswers.getDefaultAnswer();
    }
}
