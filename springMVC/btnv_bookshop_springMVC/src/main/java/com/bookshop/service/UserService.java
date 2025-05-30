package com.bookshop.service;

import com.bookshop.entity.UserEntity;
import com.bookshop.model.response.PageResponse;

import java.util.List;

public interface UserService {
    public PageResponse<List<UserEntity>> getUserRole(Long pageSize, Long pageIndex, String userName, String roleName);
}
