package Database;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ApplicationDb {
    public static Connection connection;

    public static Connection connect() {

        connection = null;

        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource)context.lookup("java:/comp/env/jdbc/OracleDB");
            connection = dataSource.getConnection();
            System.out.println("Conexão realizada!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void Disconnect() {
        try {
            connection.close();
        } catch (SQLException exception){
            System.out.print("Erro de conexão");
        }

    }
}
