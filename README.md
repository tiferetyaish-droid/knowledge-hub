AI-Powered Knowledge Hub - Yashir Assignment
Overview
This project is a Knowledge Management System that leverages simulated AI to process different types of documents (Policies, Reports, and Manuals). The system provides tailored summaries and answers based on the specific document type and implements a robust, annotation-based security mechanism.

Key Features
Dynamic LLM Processing: Uses a Strategy Pattern to apply different logic for various document types.

AOP Security: Implements custom annotation-based access control (@RequiresRole) to decouple security from business logic.

Fullstack Integration: A Spring Boot Backend integrated with a React-based Frontend.

Architectural Highlights (Backend)
Strategy Pattern (Document Processors): Instead of using complex conditional logic (if-else), I implemented a DocumentProcessor interface. This allows for easy extension; adding a new document type is as simple as adding a new class without modifying existing code (Open/Closed Principle).

Aspect-Oriented Programming (AOP): To handle authorization "smartly", I created an Aspect (RoleCheckAspect) that intercepts requests. It validates the user's role before the execution of controller methods, keeping the controllers clean and focused.

Dependency Injection: Leveraged Spring's DI to automatically discover and map all available processors at startup.

Tech Stack
Backend: Java 17, Spring Boot 3.3.4, Spring AOP.

Frontend: React (Hooks & Fetch API).

Build Tool: Maven.

How to Run
Prerequisites: Ensure you have Java 17+ and Maven installed.

Build the project:

Bash

mvn clean install
Run the application: Run the KnowledgeHubApplication class from your IDE or use:

Bash

mvn spring-boot:run
Access the System: Open your browser and navigate to: http://localhost:8080

Assumptions
The user's role is passed as a query parameter (role=ADMIN or role=USER) for the purpose of this demonstration.

In a production environment, this would be replaced by a proper JWT/OAuth2 authentication mechanism.