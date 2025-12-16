package com.example.knowledgehub.model;

import java.time.LocalDateTime;

public class Document {
    private Long id;
    private String name;
    private String type; // POLICY, REPORT, MANUAL
    private String content;
    private String uploader;
    private LocalDateTime uploadDate;

    public Document() {
        this.uploadDate = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getUploader() { return uploader; }
    public void setUploader(String uploader) { this.uploader = uploader; }

    public LocalDateTime getUploadDate() { return uploadDate; }
    public void setUploadDate(LocalDateTime uploadDate) { this.uploadDate = uploadDate; }
}