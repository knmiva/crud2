package DAO;

import model.User;
import utils.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao{

    private static UserDaoJDBCImpl instance = new UserDaoJDBCImpl();
    private static Connection connection = DBHelper.getConnection();

    private UserDaoJDBCImpl() {
    }

    public static UserDaoJDBCImpl getInstance() {
        return instance;
    }

    @Override
    public boolean saveUser(User user) {
        String sql = "insert into users(name,email,country,mobile) value (?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getCountry());
            pstmt.setString(4, user.getMobile());
            if (pstmt.executeUpdate() != 0) {
                pstmt.close();
                return true;
            }
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteUser(User user) {

        String sql = "delete from users where id=?";
        PreparedStatement pstmt;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, user.getId());
            if (pstmt.executeUpdate() != 0) {
                pstmt.close();
                return true;
            }
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User findUserById(Long id) {
        User user = null;
        String sql = "select * from users where id=?";
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            pstmt.execute();
            ResultSet resultSet = pstmt.getResultSet();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                String mobile = resultSet.getString("mobile");
                user = new User(id, name, email, country, mobile);
            }
            resultSet.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public boolean editUser(User user) {
        String sql = "update users set name=?,email=?, country=?, mobile=? where id=?";
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getCountry());
            stmt.setString(4, user.getMobile());
            stmt.setLong(5, user.getId());
            if (stmt.executeUpdate() != 0) {
                stmt.close();
                return true;
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> findAllUsers() {
        List<User> allUsers = new ArrayList<>();
        Statement stmt;
        try {
            stmt = connection.createStatement();
            stmt.execute("select * from users");
            ResultSet result = stmt.getResultSet();
            while (result.next()) {
                Long id = result.getLong("id");
                String name = result.getString("name");
                String email = result.getString("email");
                String country = result.getString("country");
                String mobile = result.getString("mobile");
                allUsers.add(new User(id, name, email, country, mobile));
            }
            result.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allUsers;
    }
}
