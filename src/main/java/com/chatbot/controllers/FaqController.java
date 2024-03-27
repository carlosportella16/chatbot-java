package com.chatbot.controllers;

import com.chatbot.dto.MessageRequest;
import com.chatbot.utils.FaqAnswers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class FaqController {

    @PostMapping
    public ResponseEntity<String> answerQuestion(@RequestBody MessageRequest request){
        FaqAnswers faqAnswers = new FaqAnswers();
        return ResponseEntity.ok("Funcionando");
    }
}
