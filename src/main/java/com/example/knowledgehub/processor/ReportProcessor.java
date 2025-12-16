package com.example.knowledgehub.processor;

import org.springframework.stereotype.Component;

@Component
public class ReportProcessor implements DocumentProcessor {

    @Override
    public String getType() {
        return "REPORT";
    }

    @Override
    public String summarize(String content) {
        return "Report Summary: Data analysis complete. Main trends: " + content.substring(0, Math.min(content.length(), 50)) + "...";
    }

    @Override
    public String answer(String content, String question) {
        return "Based on the report, the answer to '" + question + "' is related to the analyzed data points.";
    }
}