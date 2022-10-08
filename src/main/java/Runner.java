import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //DbWork dbWork=new DbWork();
        //Connection conn =dbWork.connect_to_db("techprojdbc","postgres","canada");
        // dbWork.createTable(conn,"employees");
        // dbWork.insertInto(conn,"employees","atiye","atiye@gmail.com","brazil");
        try {

            DataBaseConnection dataBaseConnection = new DataBaseConnection();
            dataBaseConnection.conn("postgres", "canada");
            StudentManagementSystem student=new StudentManagementSystem();
            // StudentRecord studentRecord=new StudentRecord();
            //studentRecord.students();
            int choice = 0;
            System.out.println("WELCOME TO STUDENT RECORD SYSTEM\nPlease select the option from Menu\n1 -" +
                    " Student Registration\n 2 - Password update\n 3 - " +
                    "Delete Record\n 4- Search for a Student\n 5 - " +
                    "Show All Students\n 6 - Exit Application");
            Scanner scan = new Scanner(System.in);
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("1 pressed");
                    student.getStudentDetails();
                    student.saveStudent();
                    break;
                case 2:
                    System.out.println("2 pressed");
                    student.updatePassword();
                    break;
                case 3:
                    System.out.println("3 pressed");
                    student.deleteStudent();
                    break;
                case 4:
                    System.out.println("4 pressed");
                    student.searchStudent();
                    break;
                case 5:
                    System.out.println("5 pressed");
                    student.selectAll();
                    break;
                case 6:
                    System.out.println("6 pressed");
                    System.out.println("Thanks for using the Application");
                    break;
                default:
                    System.out.println("Please enter the correct choice between 1-6");

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    //class for student record system

    }

