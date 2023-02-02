import java.sql.Connection;
import java.sql.DriverManager;

public class DBMySQL extends BD implements DBManagment {


    public DBMySQL(String user, String password, String database, String puerto) {
        this.database = database;
        this.puerto = puerto;
        this.conexion = connectToDB(user, password);
    }

    @Override
    public Connection connectToDB(String user, String password) {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:"+puerto+"/"+this.database, user, password);
            //here sonoo is database name, root is username and password
            this.conexion = con;

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return con;
    }


}

