package services.interfaces;

import DTOs.CreateUserDTO;
import DTOs.UserDTO;
import Models.User;
import utils.Result;

import java.sql.SQLException;

public interface IUserService {
    Result<UserDTO> createUser(CreateUserDTO user) throws SQLException;
}
