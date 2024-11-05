package DAOs.Interfaces;

import java.sql.SQLException;

public interface IUserDao {
    void createUser (String user, String email, String password, String picture) throws SQLException;
}
