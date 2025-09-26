📚 Student Record Manager

A console-based Java + MySQL application to manage student records with CRUD operations (Create, Read, Update, Delete).
This project demonstrates how to use JDBC for connecting Java applications with a MySQL database.

🚀 Features

Add new student records

View all student records

Search student by ID

Update existing student details

Delete student records

Real-time database storage with MySQL

🛠️ Tech Stack

Java (Core Java, JDBC)

MySQL (Relational Database)

⚙️ Setup Instructions
1. Clone the Repository
git clone https://github.com/your-username/student-record-manager.git
cd student-record-manager

2. Create MySQL Database
CREATE DATABASE studentdb;
USE studentdb;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    grade VARCHAR(10) NOT NULL
);

3. Update Database Credentials

Inside StudentRecordManager.java, update the following with your MySQL username & password:

private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
private static final String USER = "root"; 
private static final String PASSWORD = "your_password";

4. Compile & Run
javac StudentRecordManager.java
java StudentRecordManager

📖 Example Usage
=== Student Record Manager ===
1. Add Student
2. View Students
3. Search Student
4. Update Student
5. Delete Student
6. Exit
Choose an option: 

📌 Project Structure
StudentRecordManager/
│── StudentRecordManager.java   # Main Java file (CRUD logic)
│── README.md                   # Project documentation

🔮 Future Enhancements

Add GUI using JavaFX/Swing

Export student data to CSV/Excel

Add authentication for admin access

🤝 Contributing

Feel free to fork this repo, raise issues, or submit pull requests to improve the project.
