package daoClasses;

import databaseConnection.ConnectionProvider;
import entitites.User;

import java.sql.*;

public class UserDAO {

private Connection con;
    public UserDAO() {
       con = ConnectionProvider.connectToLocal("130.225.170.222");
    }


    public User authenticateUser(int CPR, String Password) throws SQLException {
        User user = new User();
        try {
            String sql = "SELECT * FROM Person WHERE CPR=" + CPR + " and Password='" + Password + "';";
            PreparedStatement ps = con.
                    prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user.setCpr(rs.getInt("CPR"));
                user.setPassword(rs.getString("Password"));
                user.setName(rs.getString("Fornavn"));
                user.setLastname(rs.getString("Efternavn"));
                user.setDiverse(rs.getString("Diverse"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        con.close();
        return user;
    }


}
