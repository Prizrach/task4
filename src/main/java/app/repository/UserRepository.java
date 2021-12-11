package app.repository;

import app.domain.User;
import app.sql.SqlHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public final class UserRepository {

    private static Connection conn = SqlHelper.getConnection();

   public static User save (User user){
       try(PreparedStatement ps = conn.prepareStatement("INSERT INTO USER (id, LOGIN) VALUES (?,?)")){
           ps.setInt(1, user.getId());
           ps.setString(2, user.getName());
           ps.execute();
       } catch (SQLException e) {
        e.printStackTrace();
    }
		return user;
   }





}

