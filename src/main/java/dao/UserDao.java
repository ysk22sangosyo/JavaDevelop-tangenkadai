package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import enitity.User;
public class UserDao {
	private static final String SQL_SELECT_ID_AND_PASS = "SELECT login_id, name, password FROM users WHERE login_id = ? AND password = ?";
	
    private Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }

    public User findByIdAndPass(String id, String pass) {
        try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ID_AND_PASS)) {
            stmt.setString(1, id);
            stmt.setString(2, pass);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new User(rs.getString("login_id"), rs.getString("name"), rs.getString("password"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        
        }
    }
        
      
}
