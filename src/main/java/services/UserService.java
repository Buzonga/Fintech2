package services;

import DAOs.Interfaces.IUserDao;
import DAOs.UserDao;
import DTOs.CreateUserDTO;
import DTOs.LoginDTO;
import DTOs.UserDTO;
import Models.User;
import at.favre.lib.crypto.bcrypt.BCrypt;
import services.interfaces.IUserService;
import utils.EmailValidator;
import utils.Result;

import java.sql.SQLException;

public class UserService implements IUserService {

    private IUserDao _userDao;

    public UserService() {
        _userDao = new UserDao();
    }

    @Override
    public Result<UserDTO> createUser(CreateUserDTO userDto) throws SQLException {
        if (userDto.username.isEmpty()) {
            return new Result<UserDTO>().FailureResponse("nome de usuário inválido.");
        }

        if (userDto.email.isEmpty()) {
            return new Result<UserDTO>().FailureResponse("email inválido.");
        }

        if (userDto.password.isEmpty()) {
            return new Result<UserDTO>().FailureResponse("senha inválida.");
        }

        if (userDto.password.length() <= 3) {
            return new Result<UserDTO>().FailureResponse("senha muito curta.");
        }

        if (!userDto.password.equals(userDto.confirmPassword)) {
            return new Result<UserDTO>().FailureResponse("senhas não coincidem.");
        }

        if (!EmailValidator.Match(userDto.email)) {
            return new Result<UserDTO>().FailureResponse("email inválido.");
        }

        User emailInUse = _userDao.getUserByEmail(userDto.email);
        if (emailInUse != null) {
            return new Result<UserDTO>().FailureResponse("email já esta sendo utilizado.");
        }

        User usernameInUse = _userDao.getUserByUsername(userDto.username);
        if (usernameInUse != null) {
            return new Result<UserDTO>().FailureResponse("nome de usuário já esta sendo utilizado.");
        }

        String hash = BCrypt.withDefaults().hashToString(12, userDto.password.toCharArray());

        User user = new User();

        user.setEmail(userDto.email);
        user.setUsername(userDto.username);
        user.setPsw(hash);
        user.setPicture("");

        try {
            _userDao.createUser(user);
            UserDTO dto = UserDTO.Parse(user);

            return new Result<UserDTO>().SuccessResponse("Usuário criado com sucesso", dto);
        } catch (SQLException sqlException) {
            return new Result<UserDTO>().FailureResponse("Não foi possivel criar usuário.");
        }
    }

    @Override
    public Result<UserDTO> loginUser(LoginDTO user) throws SQLException {
        if (!EmailValidator.Match(user.email)) {
            return new Result<UserDTO>().FailureResponse("email inválido.");
        }

        if (user.email.isEmpty()) {
            return new Result<UserDTO>().FailureResponse("email inválido.");
        }

        if (user.password.isEmpty()) {
            return new Result<UserDTO>().FailureResponse("senha inválida.");
        }

        User userExists = _userDao.getUserByEmail(user.email);
        if (userExists == null) {
            return new Result<UserDTO>().FailureResponse("usuário não encontrado.");
        }

        BCrypt.Result isAuthenticated = BCrypt.verifyer().verify(user.password.toCharArray(), userExists.getPsw().toCharArray());

        if (!isAuthenticated.verified) {
            return new Result<UserDTO>().FailureResponse("senha inválida.");
        }

        UserDTO userDTO = UserDTO.Parse(userExists);

        return new Result<UserDTO>().SuccessResponse("Usuário criado com sucesso", userDTO);
    }
}
