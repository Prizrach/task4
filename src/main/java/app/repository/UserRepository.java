package app.repository;

import app.dao.UserDao;
import app.domain.User;
import app.sql.SqlHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public final class UserRepository implements UserDao {

//   //  try (PreparedStatement ps = conn.prepareStatement("INSERT INTO USER (id, LOGIN) VALUES (?,?)")) {
//       try (PreparedStatement ps = conn.prepareStatement("INSERT INTO USER (LOGIN) VALUES (?)")) {
//           ps.setString(1, user.getName());
//           ps.execute();
//       } catch (SQLException e) {
//           e.printStackTrace();
//       }
//   }
        Connection connection = SqlHelper.getConnection();

        @Override
        public void add (User user){
            String sql = "INSERT INTO USER (ID, LOGIN, PASSWORD) VALUES(?,?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setLong(1, user.getId());
                preparedStatement.setString(2, user.getLogin());
                preparedStatement.execute();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }

        @Override
        public List<User> getAll () {
            List<User>  userList = new ArrayList<>();

            String sql = "SELECT ID, LOGIN, PASSWORD";

            try(Statement statement = connection.createStatement()){

                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()){
                    User user = new User();
                    user.setId(resultSet.getInt("ID"));
                    user.setLogin(resultSet.getString("LOGIN"));

                    userList.add(user);
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
            return userList;
        }

        @Override
        public User getBuId (int id){
            String sql = "SELECT ID, LOGIN, PASSWORD FROM USER WHERE ID = ?";

            User user = new User();

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){

                preparedStatement.setInt(1, id);

                ResultSet resultSet = preparedStatement.executeQuery();

                user.setId(resultSet.getInt("ID"));
                user.setLogin(resultSet.getString("LOGIN"));

                preparedStatement.executeQuery();

            }catch (SQLException e){
                e.printStackTrace();
            }
            return user;
        }


        @Override
        public void update (User user){

        }

        @Override
        public void remove (User user){

        }
    }





