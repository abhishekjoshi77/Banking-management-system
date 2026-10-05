# Banking Management System

A Core Java banking application designed as a fresher-level portfolio project.

## Current Phase

The project currently includes:

- Java 17
- Maven
- Object-oriented design
- Encapsulation
- Inheritance
- Abstraction
- Polymorphism
- Custom exceptions
- ArrayList
- Stream API
- Basic console UI
- MySQL schema
- JDBC dependency

## Planned Modules

1. Core Java model and business logic
2. JDBC DAO implementation
3. MySQL CRUD
4. Deposit and withdrawal persistence
5. Fund transfer with JDBC transactions
6. Transaction history
7. Customer and admin modules
8. JUnit tests
9. Logging and README expansion

## Run

From the project directory:

```bash
mvn clean compile
mvn exec:java
```

The current demo mode runs without requiring MySQL. JDBC/MySQL persistence will be connected in the next phase.

## Database

Run:

```text
database/banking_schema.sql
```

Then update:

```text
src/main/resources/db.properties
```

with your MySQL password.

## Resume Skills Demonstrated

Core Java, OOP, Collections, Exception Handling, Streams, JDBC, MySQL, Maven, JUnit.
