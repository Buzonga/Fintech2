package services.interfaces;

import DTOs.CreateUserDTO;
import Models.User;

import java.sql.SQLException;

public interface IUserService {
    void createUser(CreateUserDTO user) throws SQLException;
}
