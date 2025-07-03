# Java JDBC Employee Database App

This is a simple yet well-structured **Employee Management System** built using **Java** and **SQLite (JDBC)**. It allows users to perform basic CRUD (Create, Read, Update, Delete) operations on an employee database via a clean console interface.

---

## 🚀 Features

- Add new employees to the database
- View all existing employee records
- Update salary of an existing employee
- Delete an employee record by ID
- Uses JDBC with SQLite for local database management

---

## 📌 Technologies Used

- Java (JDK 17+)
- SQLite
- JDBC (sqlite-jdbc-3.42.0.0)
- VS Code / IntelliJ (Recommended)

---

## 🧩 Folder Structure

Java JDBC Employee Database App/
├── Employee.java
├── EmployeeDatabase.java
├── EmployeeDatabaseApp.java
├── employee.db
├── sqlite-jdbc-3.42.0.0.jar
└── README.md


---

## 🛠️ How to Run

### 1. Compile:
bash

javac -cp ".;sqlite-jdbc-3.42.0.0.jar" Employee.java EmployeeDatabase.java EmployeeDatabaseApp.java

### 2. Run:
java -cp ".;sqlite-jdbc-3.42.0.0.jar" EmployeeDatabaseApp

✅ Make sure sqlite-jdbc-3.42.0.0.jar is present in the same directory as your .java files.

---
📝 Sample Output
Check Output.txt for a complete working example of the application in action.
---
🎯 Interview Questions:
1.What is JDBC?
2.What is PreparedStatement?
3.Difference between Statement and PreparedStatement?
4.How do you handle SQL exceptions?
5.How to prevent SQL Injection?
6.What is JDBC DriverManager?
7.How to close connections?
8.What is a ResultSet?
9.What is auto-commit in JDBC?
10.How to connect Java to MySQL?
