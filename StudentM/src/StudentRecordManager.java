import java.sql.*;
import java.util.Scanner;

public class StudentRecordManager {

    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/studentdb"; // replace with your DB name
    private static final String USER = "root"; // your MySQL username
    private static final String PASSWORD = "Tanishka@28"; // your MySQL password

    private static Connection conn;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to MySQL Database!");

            while (true) {
                System.out.println("\n=== Student Record Manager ===");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Search Student");
                System.out.println("4. Update Student");
                System.out.println("5. Delete Student");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> addStudent();
                    case 2 -> viewStudents();
                    case 3 -> searchStudent();
                    case 4 -> updateStudent();
                    case 5 -> deleteStudent();
                    case 6 -> {
                        System.out.println("Exiting...");
                        conn.close();
                        return;
                    }
                    default -> System.out.println("Invalid choice! Try again.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 1. Add Student
    private static void addStudent() {
        try {
            System.out.print("Enter Name: ");
            sc.nextLine(); // consume newline
            String name = sc.nextLine();
            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            System.out.print("Enter Grade: ");
            String grade = sc.next();

            String sql = "INSERT INTO students(name, age, grade) VALUES(?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, grade);
            ps.executeUpdate();
            System.out.println(" Student Added Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 2. View Students
    private static void viewStudents() {
        try {
            String sql = "SELECT * FROM students";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("\n--- Student List ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Age: " + rs.getInt("age") +
                        ", Grade: " + rs.getString("grade"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 3. Search Student
    private static void searchStudent() {
        try {
            System.out.print("Enter Student ID to search: ");
            int id = sc.nextInt();
            String sql = "SELECT * FROM students WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(" Student Found: ");
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Age: " + rs.getInt("age") +
                        ", Grade: " + rs.getString("grade"));
            } else {
                System.out.println(" Student not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 4. Update Student
    private static void updateStudent() {
        try {
            System.out.print("Enter Student ID to update: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.print("Enter New Name: ");
            String name = sc.nextLine();
            System.out.print("Enter New Age: ");
            int age = sc.nextInt();
            System.out.print("Enter New Grade: ");
            String grade = sc.next();

            String sql = "UPDATE students SET name=?, age=?, grade=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, grade);
            ps.setInt(4, id);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println(" Student Updated Successfully!");
            } else {
                System.out.println(" Student ID not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 5. Delete Student
    private static void deleteStudent() {
        try {
            System.out.print("Enter Student ID to delete: ");
            int id = sc.nextInt();

            String sql = "DELETE FROM students WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println(" Student Deleted Successfully!");
            } else {
                System.out.println(" Student ID not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
