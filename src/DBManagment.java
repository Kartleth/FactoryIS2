import java.sql.*;

public interface DBManagment {
    Connection connectToDB(String user, String password);
    ResultSet querySelect(String query);

}