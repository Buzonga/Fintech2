package services;

import DAOs.Interfaces.IUserDao;
import DAOs.UserDao;
import DTOs.CreateUserDTO;
import Models.User;
import at.favre.lib.crypto.bcrypt.BCrypt;
import services.interfaces.IUserService;
import utils.EmailValidator;

import java.sql.SQLException;

public class UserService implements IUserService {

    private IUserDao _userDao;

    public UserService() {
        _userDao = new UserDao();
    }

    @Override
    public void createUser(CreateUserDTO userDto) throws SQLException {
        if (userDto.username.isEmpty()) {
            throw new SQLException("nome de usuário inválido.");
        }

        if (userDto.email.isEmpty()) {
            throw new SQLException("Email inválido.");
        }

        if (userDto.password.isEmpty()) {
            throw new SQLException("senha inválida.");
        }

        if (userDto.password != userDto.confirmPassword) {
            throw new SQLException("senhas não coincidem.");
        }

        if (!EmailValidator.Match(userDto.email)) {
            throw new SQLException("Email inválido.");
        }

        User emailInUse = _userDao.getUserByEmail(userDto.email);
        if (emailInUse != null) {
            throw new SQLException("erro ao criar usuário. Email já esta em uso.");
        }

        User usernameInUse = _userDao.getUserByUsername(userDto.username);
        if (usernameInUse != null) {
            throw new SQLException("erro ao criar usuário. Email já esta em uso.");
        }

        String hash = BCrypt.withDefaults().hashToString(12, userDto.password.toCharArray());

        User user = new User();

        user.setEmail(userDto.email);
        user.setUsername(userDto.username);
        user.setPsw(hash);
        user.setPicture("");

        try {
            _userDao.createUser(user);
        } catch (SQLException sqlException) {
            System.out.println("sqlException");
        }
    }
}
