package service;

import DAO.UserDaoFactory;
import model.User;

import java.util.List;

public class UserService {

    private static UserService instance = new UserService();
    private static UserDaoFactory userDaoFactory = new UserDaoFactory();


    private UserService() {
    }

    public static UserService getInstance() {
        return instance;
    }

    public boolean saveUser(String name, String email, String country, String mobile) {
        User user = new User(name, email, country, mobile);
        userDaoFactory.getUserDao().saveUser(user);
        return true;
    }

    public boolean editUser(User user) {
        userDaoFactory.getUserDao().editUser(user);
        return true;
    }

    public boolean deleteUser(User user) {
        userDaoFactory.getUserDao().deleteUser(user);
        return true;
    }

    public User findUserById(Long id) {
        return userDaoFactory.getUserDao().findUserById(id);
    }

    public List<User> findAllUsers() {
        List<User> userList = userDaoFactory.getUserDao().findAllUsers();
        return userList;
    }
}
