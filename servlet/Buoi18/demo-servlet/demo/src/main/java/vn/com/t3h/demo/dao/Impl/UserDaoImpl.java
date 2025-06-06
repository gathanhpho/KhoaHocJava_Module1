package vn.com.t3h.demo.dao.Impl;

import vn.com.t3h.demo.dao.IUserDao;
import vn.com.t3h.demo.model.UserModel;
import vn.com.t3h.demo.Utils.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao {

    public List<UserModel> getUsers() {
        Connection conn = DataSourceUtils.getConnection();
        List<UserModel> users = new ArrayList<UserModel>();

        String sql = "select * from user";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                UserModel user = new UserModel();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setFullName(rs.getString("full_name"));
                user.setAge(rs.getInt("age"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DataSourceUtils.close(conn,ps,rs);
        }
        return users;
    }

}