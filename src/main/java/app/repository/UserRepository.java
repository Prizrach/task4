package app.repository;

import app.dao.UserDao;
import app.domain.User;
import app.sql.SqlHelper;

import javax.jws.soap.SOAPBinding;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public final class UserRepository implements UserDao {


    @Override
    public void add(User user) {
        String sql = "INSERT INTO USER (LOGIN) VALUES(?)";
        try (Connection connection = SqlHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM `USER`";
        try (Connection connection = SqlHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getInt("ID"));
                    user.setLogin(resultSet.getString("LOGIN"));
                    userList.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public User getById(int id) {
        String sql = "SELECT * FROM `USER` WHERE ID = ?";
        User user = new User();
        try (Connection connection = SqlHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
             preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();
                user.setId(resultSet.getInt("ID"));
                user.setLogin(resultSet.getString("LOGIN"));
                user.setPassword(resultSet.getString("PASSWORD"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    @Override
    public void update(User user) {

    }

    @Override
    public void remove(User user) {

    }

    @Override
    public User getByLogin(String login) {
        String sql = "SELECT * FROM `USER` WHERE LOGIN = ?";

        User user = new User();

        try (Connection connection = SqlHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, login);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();
                user.setId(resultSet.getInt("ID"));
                user.setLogin(resultSet.getString("LOGIN"));
                user.setPassword(resultSet.getString("PASSWORD"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}





