package DAO;

import model.User;

import java.util.List;

public interface UserDao {

    boolean saveUser(User user);

    boolean editUser(User user);

    boolean deleteUser(User user);

    User findUserById(Long id);

    <T> List<T> findAllUsers();
}
