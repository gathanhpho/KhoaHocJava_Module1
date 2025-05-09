package buoi15;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/ql_sp";
        String user = "root";
        String password = "aicap2003";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            String sql = "select * from production";
            Statement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("--------");


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

//https://stackoverflow.com/questions/11161248/setting-java-home