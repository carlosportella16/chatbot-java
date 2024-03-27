package com.chatbot.controllers;

import com.chatbot.dto.MessageRequest;
import com.chatbot.dto.MessageResponse;
import com.chatbot.services.FaqService;
import com.chatbot.utils.FaqAnswers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class FaqController {

    private FaqService faqService;

    public FaqController(FaqService faqService) {
        this.faqService = faqService;
    }

    @PostMapping
    public ResponseEntity<MessageResponse> answerQuestion(@RequestBody MessageRequest request){
        String answer = this.faqService.getAnswer(request.message());
        MessageResponse response = new MessageResponse(answer);
        return ResponseEntity.ok(response);
    }
}
