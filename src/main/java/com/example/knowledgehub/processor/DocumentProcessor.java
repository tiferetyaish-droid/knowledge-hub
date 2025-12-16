package com.example.knowledgehub.processor;

public interface DocumentProcessor {
    String getType();
    String summarize(String content);
    String answer(String content, String question);
}