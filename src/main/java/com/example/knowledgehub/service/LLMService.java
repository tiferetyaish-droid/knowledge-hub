package com.example.knowledgehub.service;

import com.example.knowledgehub.processor.DocumentProcessor;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LLMService {
    private final Map<String, DocumentProcessor> processors = new HashMap<>();

    public LLMService(List<DocumentProcessor> processorList) {
        for (DocumentProcessor p : processorList) {
            processors.put(p.getType().toUpperCase(), p);
        }
    }

    public String summarize(String content, String type) {
        DocumentProcessor p = processors.get(type.toUpperCase());
        if (p != null) {
            return p.summarize(content);
        }
        return "Summary for " + type + ": " + content;
    }

    public String answerQuestion(String content, String question, String type) {
        DocumentProcessor p = processors.get(type.toUpperCase());
        if (p != null) {
            return p.answer(content, question);
        }
        return "Default answer for " + question;
    }
}