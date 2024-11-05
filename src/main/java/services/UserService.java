package services;

import DAOs.Interfaces.IUserDao;
import DAOs.UserDao;
import Models.User;
import services.interfaces.IUserService;

import java.sql.SQLException;

public class UserService implements IUserService {

    private IUserDao _userDao;

    public UserService() {
        _userDao = new UserDao();
    }

    @Override
    public void createUser(User user) {
        try {
            _userDao.createUser(user.getUsername(), user.getEmail(), user.getPsw(), user.getPicture());
        } catch (SQLException sqlException) {
            System.out.println("sqlException");
        }
    }
}
