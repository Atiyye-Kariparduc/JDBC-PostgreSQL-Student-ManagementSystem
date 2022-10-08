import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBwork {
    Connection connection;
    public Connection connect_to_db(String dbName,String username,String password) throws ClassNotFoundException, SQLException {
        //load postgresql driver
        Class.forName("org.postgresql.Driver");
        //setting up to the connection
        connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+ dbName,username,password);
        //passing condition to check the connection
        if(connection!=null){
            System.out.println("succesfull");
        }else{
            System.out.println("not established");
        }


        return connection;
    }
    //create new method to createTable
    public void createTable(Connection connection,String tableName) throws SQLException {
        Statement statement;
        String query= "CREATE TABLE "+tableName+"(empId SERIAL, name varchar(200), email varchar(200), country varchar(200), age integer, salary integer, primary key(empId))";
        //String query = "create table "+tableName+"(empId SERIAL, name varchar(200), email varchar(200), country varchar(200), age integer, salary integer, primary key(empId))";
        statement=connection.createStatement();
        statement.executeUpdate(query);
        System.out.println("table created");

    }
    public void insertInto(Connection connection,String tableName,String name,String email,String country) throws SQLException {
        Statement statement = null;
        String query = String.format("insert into %s(name,email,country ) values('%s','%s','%s')", tableName,name,email,country);
        statement=connection.createStatement();
        statement.executeUpdate(query);
        System.out.println("inserted");

    }

}
