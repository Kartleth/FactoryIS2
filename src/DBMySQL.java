import java.sql.Connection;
import java.sql.DriverManager;

public class DBMySQL extends BD implements DBManagment {
    private final String user;
    private final String password;

    public DBMySQL(String user, String password, String database, String puerto) {
        this.database = database;
        this.puerto = puerto;
        this.user = user;
        this.password = password;


    }

    @Override
    public Connection connectToDB() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:"+this.puerto+"/"+this.database, this.user, this.password);
            //here sonoo is database name, root is username and password
            this.conexion = con;

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return con;
    }


}

