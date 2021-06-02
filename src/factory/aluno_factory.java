package factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class aluno_factory {
    private static final String USERNAEM = "root";
    private static final String PASSWORD = "Andarilhosolitario21";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/aplicativo_java";


    public static Connection createConnectionToMySQL() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAEM, PASSWORD);

        return connection;
    }

    public static void main (String[] args) throws Exception{

        Connection con = createConnectionToMySQL();

        if(con!=null){
            System.out.println("Conexão obtida!");
            con.close();
        }
        

    }




}
