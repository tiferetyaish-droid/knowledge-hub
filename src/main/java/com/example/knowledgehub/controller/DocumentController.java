package com.example.knowledgehub.controller;

import com.example.knowledgehub.model.Document;
import com.example.knowledgehub.service.DocumentService;
import com.example.knowledgehub.service.LLMService;
import com.example.knowledgehub.security.RequiresRole;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    private final DocumentService documentService;
    private final LLMService llmService;

    public DocumentController(DocumentService documentService, LLMService llmService) {
        this.documentService = documentService;
        this.llmService = llmService;
    }

    @PostMapping
    @RequiresRole("ADMIN")
    public Document upload(@RequestBody Document doc) {
        return documentService.upload(doc);
    }

    @GetMapping
    public List<Document> list() {
        return documentService.list();
    }

    @GetMapping("/{id}/summary")
    public String getSummary(@PathVariable Long id) {
        Document doc = documentService.findById(id);
        return llmService.summarize(doc.getContent(), doc.getType());
    }
}