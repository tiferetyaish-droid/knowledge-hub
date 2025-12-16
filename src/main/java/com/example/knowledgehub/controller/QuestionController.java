package com.example.knowledgehub.controller;

import com.example.knowledgehub.model.Document;
import com.example.knowledgehub.service.DocumentService;
import com.example.knowledgehub.service.LLMService;
import com.example.knowledgehub.security.RequiresRole;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final DocumentService documentService;
    private final LLMService llmService;

    public QuestionController(DocumentService documentService, LLMService llmService) {
        this.documentService = documentService;
        this.llmService = llmService;
    }

    @PostMapping("/ask")
    public String ask(@RequestParam Long documentId, @RequestParam String question) {

        Document doc = documentService.findById(documentId);
        if (doc == null) {
            throw new RuntimeException("Document not found!");
        }


        return llmService.answerQuestion(doc.getContent(), question, doc.getType());
    }
}