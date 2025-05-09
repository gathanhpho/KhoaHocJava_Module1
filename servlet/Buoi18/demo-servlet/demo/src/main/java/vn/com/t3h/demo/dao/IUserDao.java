package vn.com.t3h.demo.dao;

import vn.com.t3h.demo.model.UserModel;

import java.util.List;

public interface IUserDao {

    List<UserModel> getUsers();
}