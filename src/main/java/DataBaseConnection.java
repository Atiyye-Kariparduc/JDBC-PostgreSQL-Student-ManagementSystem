import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    public Connection conn(String user, String password) throws ClassNotFoundException, SQLException {
        Connection connection=null;
        //load the class
        Class.forName("org.postgresql.Driver");
        //setting up connection get connection from DriverManager
        connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/techprojdbc",user,password);
        if(connection!=null){
            System.out.println("connected");
        }else{
            System.out.println("not connected");
        }
        return connection;
    }
}
