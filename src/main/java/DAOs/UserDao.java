package DAOs;
import DAOs.Interfaces.UserDaoInterface;
import Database.ApplicationDb;
import Models.User;
import java.util.UUID;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.Instant;

public class UserDao implements UserDaoInterface {
    Connection connection = null;

    @Override
    public void createUser(String user, String email, String password, String picture) throws SQLException {


        this.connection = ApplicationDb.connect();
        UUID uuid = UUID.randomUUID();
        String query = "INSERT INTO USERS (id, email, username, psw, picture, balance) VALUES " +
                "(?, ?, ?, ?, ?, ?)";
        PreparedStatement stm = this.connection.prepareStatement(query);
        stm.setString(1, uuid.toString());
        stm.setString(2, email);
        stm.setString(3, user);
        stm.setString(4, password);
        stm.setString(5, picture);
        stm.setFloat(6, 0);
        stm.executeQuery();
        this.connection.close();
    }
}
