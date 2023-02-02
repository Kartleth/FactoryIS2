/*
import java.sql.*;

public abstract class BD {
    String puerto;
    String database;
    Connection conexion = null;

    public ResultSet querySelect(String query) {
        ResultSet rs = null;
        try {
            Statement stmt = this.conexion.createStatement();
            rs = stmt.executeQuery(query);
            /*
            while (rs.next())
                System.out.println(rs.getInt(1));
            */

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return rs;
    }

    public void queryInsert(String query) {

    }

    public void closeConnection() {
        try {
            this.conexion.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }


    public abstract Connection connectToDB(String user, String password);


}

*/
import java.sql.*;
public class BD {
    private static final String url = "jdbc:postgresql://localhost:5432/truebeauty";
    private static final String user = "admin1";
    private static final String password = "admin_123";
    public static void main(String[] args) throws Exception {
        connect(url,user,password);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/truebeauty", "admin", "admin_123");
            //here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from usuario");
            while(rs.next())
                System.out.println(rs.getString(1)+"  "+rs.getString(2));
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static Connection connect(String url, String user, String password) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("select * from phonebook");
            while(rs.next())
                System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}

