package DAOs.Interfaces;
import Models.User;

import java.sql.SQLException;

public interface UserDaoInterface {
    void createUser (String user, String email, String password, String picture) throws SQLException;
}
