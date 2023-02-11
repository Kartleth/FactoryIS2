import java.sql.Connection;
import java.sql.DriverManager;

public class DBPostgreSQL extends BD implements DBManagment {
    private final String user;
    private final String password;

    public DBPostgreSQL(String user, String password, String database, String puerto) {
        this.database = database;
        this.puerto = puerto;
        this.user = user;
        this.password = password;

    }

    @Override
    public Connection connectToDB() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
        }
        Connection connection = null;
// Database connect
// Conectamos con la base de datos
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:"+this.puerto+"/"+this.database
                    ,this.user,this.password);
            boolean valid = connection.isValid(50000);
            System.out.println(valid ? "TEST OK" : "TEST FAIL");

        }catch (Exception e){
            System.out.println(e.toString());
        }
        return connection;
    }


}
