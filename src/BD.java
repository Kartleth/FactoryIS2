import java.sql.*;

public class BD {
    private String user;
    private String password;


    public BD(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/prueba","root","password");
            //here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from tabla1");
            while(rs.next())
                System.out.println(rs.getInt(1));
            con.close();
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}


