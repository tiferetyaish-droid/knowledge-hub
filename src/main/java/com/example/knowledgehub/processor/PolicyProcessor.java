package com.example.knowledgehub.processor;

import org.springframework.stereotype.Component;

@Component
public class PolicyProcessor implements DocumentProcessor {
    public String getType() { return "POLICY"; }

    public String summarize(String content) {
        return "Policy Summary: Organizational rules for " + content;
    }

    public String answer(String content, String question) {
        return "According to Section 1.1: The answer to '" + question + "' is regulated by policy.";
    }
}