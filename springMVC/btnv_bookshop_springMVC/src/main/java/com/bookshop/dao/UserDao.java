package com.bookshop.dao;

import com.bookshop.entity.UserEntity;

import java.util.List;

public interface UserDao {
    public Long coutUserRole(String userName, String roleName);

    public List<UserEntity> searchUserPaging(Long limit, Long offset, String userName, String roleName);
}
