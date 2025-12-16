package com.example.knowledgehub.model;

public class Question {
    private Long id;
    private Long documentId;
    private String text;
    private String answer;

    public Question() {}


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getDocumentId() { return documentId; }
    public void setDocumentId(Long documentId) { this.documentId = documentId; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public String getAnswer() { return answer; }
    public void setAnswer(String answer) { this.answer = answer; }
}