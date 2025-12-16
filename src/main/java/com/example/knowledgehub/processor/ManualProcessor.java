package com.example.knowledgehub.processor;

import org.springframework.stereotype.Component;

@Component
public class ManualProcessor implements DocumentProcessor {
    public String getType() { return "MANUAL"; }

    public String summarize(String content) {
        return "Manual Summary: Steps to handle " + content;
    }

    public String answer(String content, String question) {
        return "To answer your question: Step 1: Open the manual. Step 2: Follow instructions. Step 3: Success!";
    }
}