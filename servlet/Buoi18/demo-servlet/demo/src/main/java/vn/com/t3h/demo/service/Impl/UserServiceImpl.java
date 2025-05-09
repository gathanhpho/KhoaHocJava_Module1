package vn.com.t3h.demo.service.Impl;

import vn.com.t3h.demo.dao.IUserDao;
import vn.com.t3h.demo.dao.Impl.UserDaoImpl;
import vn.com.t3h.demo.model.UserModel;
import vn.com.t3h.demo.service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {

    private IUserDao userDao = null;
    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }
    @Override
    public List<UserModel> getListUser() {
        return userDao.getUsers();
    }
}