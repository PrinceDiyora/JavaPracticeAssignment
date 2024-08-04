import java.util.Scanner;

class Student1 {
    private int studentID;
    private String name;
    private int age;
    private String department;

    public Student1(int studentID, String name, int age, String department) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                '}';
    }
}

public class StudentRecordSystem {

    private Student1[] students;
    private int count;

    public StudentRecordSystem() {
        students = new Student1[100]; 
        count = 0;
    }

    public void addStudent(Student1 student) {
        students[count++] = student;
    }

    public Student1 getStudent(int studentID) {
        for (int i = 0; i < count; i++) {
            if (students[i].getStudentID() == studentID) {
                return students[i];
            }
        }
        return null; 
    }

    public void displayAllStudents() {
        if (count == 0) {
            System.out.println("No students in the system.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(students[i].toString());
        }
    }
}
class StudentRecordMGMT {
    public static void main(String[] args) {
        StudentRecordSystem system = new StudentRecordSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Record Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Get Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int studentID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter student department: ");
                    String department = scanner.nextLine();
                    Student1 student = new Student1(studentID, name, age, department);
                    system.addStudent(student);
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    System.out.print("Enter student ID to get: ");
                    int idToGet = scanner.nextInt();
                    scanner.nextLine();
                    Student1 foundStudent = system.getStudent(idToGet);
                    if (foundStudent != null) {
                        System.out.println("Student found: " + foundStudent.toString());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    system.displayAllStudents();
                    break;

                case 4:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
            }
        }
    }

}
