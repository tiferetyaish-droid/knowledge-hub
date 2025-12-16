package com.example.knowledgehub.service;

import com.example.knowledgehub.model.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentService {
    private final List<Document> documents = new ArrayList<>();

    public Document upload(Document doc) {
        documents.add(doc);
        return doc;
    }

    public List<Document> list() {
        return documents;
    }

    public void delete(Long id) {
        Document toRemove = null;
        for (Document doc : documents) {
            if (doc.getId().equals(id)) {
                toRemove = doc;
                break;
            }
        }
        if (toRemove != null) {
            documents.remove(toRemove);
        }
    }

    public Document findById(Long id) {
        for (Document doc : documents) {
            if (doc.getId().equals(id)) {
                return doc;
            }
        }
        return null;
    }
}