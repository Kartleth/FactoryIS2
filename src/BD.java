
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

    public abstract Connection connectToDB();


}
