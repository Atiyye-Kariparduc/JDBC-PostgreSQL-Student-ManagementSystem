import java.sql.*;
import java.util.Scanner;

public class StudentManagementSystem {

    private String name;
    private String email;
    private String password;
    private String country;
    private int marks;
    private int age;

    //making a method that takes user da==information
    public void getStudentDetails() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Student Name:");
        name = input.nextLine();
        System.out.print("Enter Student Email:");
        email = input.nextLine();
        System.out.print("Enter Student Password:");
        password = input.nextLine();
        System.out.print("Enter Student Country:");
        country = input.nextLine();
        System.out.print("Enter Student Total Marks:");
        marks = input.nextInt();
        System.out.print("Enter Student Age:");
        age = input.nextInt();
    }

    //making a method that takes the data from the user and save it into database
    public void saveStudent() throws SQLException, ClassNotFoundException {
        //calling the database connection class
        DataBaseConnection db = new DataBaseConnection();
        Connection con = db.conn("postgres", "canada");

        String sql = "insert into students values (?,?,?,?,?,?);";

        //preparedStatements for getting the data from of the students repeatedly
        PreparedStatement stmt = con.prepareStatement(sql);

        //saving the data to particular columns
        stmt.setString(1, name);
        stmt.setString(2, email);
        stmt.setString(3, password);
        stmt.setString(4, country);
        stmt.setInt(5, marks);
        stmt.setInt(6, age);

        //execute the statement
        stmt.executeUpdate();
        System.out.println("Data has been saved successfully!");
    }

    //method for updating the password
    public void updatePassword() throws SQLException, ClassNotFoundException {
        //calling the database connection class
        DataBaseConnection db = new DataBaseConnection();
        Connection con = db.conn("postgres", "canada");

        System.out.println("Please enter your email");
        Scanner input = new Scanner(System.in);
        String inputEmail = input.nextLine();

        System.out.println("Enter new Password:");
        String newPass = input.nextLine();
        //writing the SQL query
        String sql = "update students set password = ? where email = ?;";
        PreparedStatement stmt = con.prepareStatement(sql);
        //saving the data to particular columns
        stmt.setString(1, newPass);
        stmt.setString(2, inputEmail);

        int i = stmt.executeUpdate();

        //checking if the email already exist in the database or not
        if (i > 0) {
            System.out.println("Password has been updated successfully!");
        } else {
            System.out.println("This Email doesn't exist into database");
        }
    }

    //making a method that delete the student record
    public void deleteStudent() throws SQLException, ClassNotFoundException {
        //calling the database connection class
        DataBaseConnection db = new DataBaseConnection();
        Connection con = db.conn("postgres", "canada");

        System.out.println("Please enter the Student Email");
        Scanner input = new Scanner(System.in);
        String inputemail = input.nextLine();

        String sql = "delete from students where email = ?;";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, inputemail);

        int i = stmt.executeUpdate();

        //checking if the email already exist in the database or not
        if (i > 0) {
            System.out.println("Record Has Been Deleted successfully!");
        } else {
            System.out.println("This Email doesn't exist into database");
        }
    }

    //making a method to search for any particular student
    public void searchStudent() throws SQLException, ClassNotFoundException {
        //calling the database connection class
        DataBaseConnection db = new DataBaseConnection();
        Connection con = db.conn("postgres", "canada");
        System.out.println("Please enter the Student Name");
        Scanner input = new Scanner(System.in);
        String inputname = input.nextLine();

        String sql = "select * from students where name = ?;";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, inputname);

        ResultSet rs = stmt.executeQuery();

        //if we are getting no record

        while (rs.next()) {
            //print all the columns
            System.out.print(rs.getString("name") + " ");
            System.out.print(rs.getString("email") + " ");
            System.out.print(rs.getString("password") + " ");
            System.out.print(rs.getString("country") + " ");
            System.out.print(rs.getString("marks") + " ");
            System.out.println(rs.getString("age") + " ");

        }
    }

    public void selectAll() throws SQLException, ClassNotFoundException {
        DataBaseConnection db = new DataBaseConnection();
        Connection con = db.conn("postgres", "canada");
        Statement statement = null;
        String query = "select * from students";
        statement = con.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            //print all the columns
            System.out.print(rs.getString("name") + " ");
            System.out.print(rs.getString("email") + " ");
            System.out.print(rs.getString("password") + " ");
            System.out.print(rs.getString("country") + " ");
            System.out.print(rs.getString("marks") + " ");
            System.out.println(rs.getString("age") + " ");
        }

    }
}





