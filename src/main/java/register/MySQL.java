package register;

import java.sql.*;

public class MySQL {

    private static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/assignmentjavalogin", "root", "");
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    private static void close(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static boolean login(String user, String pass) {
        Connection con = null;

        try {
            con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE username='" + user + "' AND password='" + pass + "'");

            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        close(con);
        return false;
    }

    public static boolean signup(String user, String pass) {
        Connection con = null;

        try {
            con = getConnection();
            Statement stmt = con.createStatement();
            int result = stmt.executeUpdate("INSERT INTO users VALUES( NULL," + user + ", " + pass + "); ");

            if (result == 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        close(con);
        return false;
    }
}
