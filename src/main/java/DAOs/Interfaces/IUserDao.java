package DAOs.Interfaces;

import Models.User;

import java.sql.SQLException;

public interface IUserDao {
    void createUser (User user) throws SQLException;
    User getUserByEmail(String email) throws SQLException;
    User getUserByUsername(String username) throws SQLException;
}
