package com.example.knowledgehub.service;

import com.example.knowledgehub.model.Document;
import com.example.knowledgehub.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final DocumentService documentService;
    private final UserService userService;

    public DataInitializer(DocumentService documentService, UserService userService) {
        this.documentService = documentService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) {
        userService.create(new User(1L, "Admin User", "ADMIN"));
        userService.create(new User(2L, "Standard User", "USER"));

        Document policyDoc = new Document();
        policyDoc.setId(1L);
        policyDoc.setName("מדיניות רכב חברה 2024");
        policyDoc.setType("POLICY");
        policyDoc.setContent("סעיף א: כל עובד עם ותק של שנה זכאי לרכב. סעיף ב: הגבלת קילומטראז' שנתית היא 25,000 קמ.");
        policyDoc.setUploader("מערכת");
        documentService.upload(policyDoc);

        Document manualDoc = new Document();
        manualDoc.setId(2L);
        manualDoc.setName("מדריך התחברות ל-VPN");
        manualDoc.setType("MANUAL");
        manualDoc.setContent("שלב 1: פתח את אפליקציית ה-AnyConnect. שלב 2: הזן שם משתמש וסיסמה. שלב 3: אשר את ההתראה בטלפון.");
        manualDoc.setUploader("מערכת");
        documentService.upload(manualDoc);

        Document reportDoc = new Document();
        reportDoc.setId(3L);
        reportDoc.setName("דוח מכירות רבעון 3");
        reportDoc.setType("REPORT");
        reportDoc.setContent("המכירות עלו ב-15% בהשוואה לרבעון הקודם. חלה עלייה משמעותית בביקוש למוצרי ענן.");
        reportDoc.setUploader("מערכת");
        documentService.upload(reportDoc);


        System.out.println("-------------------------------------------");
        System.out.println(">> נתוני דוגמה נטענו בהצלחה למערכת! <<");
        System.out.println("-------------------------------------------");
    }
}