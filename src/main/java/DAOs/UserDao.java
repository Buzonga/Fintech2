package DAOs;
import DAOs.Interfaces.IUserDao;
import Database.ApplicationDb;
import Models.User;
import java.util.UUID;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.Instant;

public class UserDao implements IUserDao {
    Connection connection = null;

    @Override
    public void createUser(User user) throws SQLException {


        this.connection = ApplicationDb.connect();
        UUID uuid = UUID.randomUUID();
        String query = "INSERT INTO USERS (id, email, username, psw, picture, balance) VALUES " +
                "(?, ?, ?, ?, ?, ?)";
        PreparedStatement stm = this.connection.prepareStatement(query);
        stm.setString(1, uuid.toString());
        stm.setString(2, user.getEmail());
        stm.setString(3, user.getUsername());
        stm.setString(4, user.getPsw());
        stm.setString(5, user.getPicture());
        stm.setFloat(6, 0);
        stm.executeQuery();
        this.connection.close();
    }

    @Override
    public User getUserByEmail(String email) throws SQLException {
        this.connection = ApplicationDb.connect();
        String query = "SELECT id, email, psw, username, picture, balance FROM USERS WHERE email = ?";

        PreparedStatement stm = this.connection.prepareStatement(query);
        stm.setString(1, email);

        ResultSet result = stm.executeQuery();

        if (result.next()) {
            User user = new User();
            user.setId(UUID.fromString(result.getString("id")).toString());
            user.setEmail(result.getString("email"));
            user.setUsername(result.getString("username"));
            user.setPsw(result.getString("psw"));
            user.setPicture(result.getString("picture"));
            user.setBalance(result.getFloat("balance"));

            this.connection.close();
            return user;
        }

        this.connection.close();
        return null;
    }

    @Override
    public User getUserByUsername(String username) throws SQLException {
        this.connection = ApplicationDb.connect();
        String query = "SELECT id, email, psw, username, picture, balance FROM USERS WHERE username = ?";

        PreparedStatement stm = this.connection.prepareStatement(query);
        stm.setString(1, username);

        ResultSet result = stm.executeQuery();

        if (result.next()) {
            User user = new User();
            user.setId(UUID.fromString(result.getString("id")).toString());
            user.setEmail(result.getString("email"));
            user.setUsername(result.getString("username"));
            user.setPsw(result.getString("psw"));
            user.setPicture(result.getString("picture"));
            user.setBalance(result.getFloat("balance"));

            this.connection.close();
            return user;
        }

        this.connection.close();
        return null;
    }
}
