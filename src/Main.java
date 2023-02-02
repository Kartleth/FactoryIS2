import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        BD database = new DBMySQL("root","luis2002", "prueba","3306");
        BD database2 = new DBPostgreSQL("postgres","luis2002", "prueba","5432");
        ResultSet tabla =  database.querySelect("SELECT * FROM tabla1");
        ResultSet tabla2 =  database2.querySelect("SELECT * FROM tabla1");
        try {
            System.out.println("IMPRIMIENDO TABLA 1 DE MYSQL ");
            while (tabla.next())
                System.out.println(tabla.getInt(1));
            System.out.println("IMPRIMIENDO TABLA 1 DE POSTGRESQL ");
            while (tabla2.next())
                System.out.println(tabla2.getInt(1));


        }catch(Exception e){
            System.out.println(e.toString());
        }



    }
}