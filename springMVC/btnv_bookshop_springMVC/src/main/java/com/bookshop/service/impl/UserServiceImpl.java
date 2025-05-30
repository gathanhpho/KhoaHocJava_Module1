package com.bookshop.service.impl;

import com.bookshop.dao.UserDao;
import com.bookshop.entity.UserEntity;
import com.bookshop.model.response.PageResponse;
import com.bookshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userHibernateDaoImpl")
    private UserDao userDao;


    @Override
    public PageResponse<List<UserEntity>> getUserRole(Long pageSize, Long pageIndex, String userName, String roleName) {

        Long coutUserRole = userDao.coutUserRole(userName, roleName);

        Long totalPage = coutUserRole / pageSize;
        if (coutUserRole % pageSize > 0) {
            totalPage++;
        }

        Long offset = (pageIndex - 1) * pageSize;

        List<UserEntity> userEntities = userDao.searchUserPaging(pageSize, offset, userName, roleName);

        PageResponse<List<UserEntity>> response = new PageResponse<>();
        response.setMessage("Success");
        response.setCode(HttpStatus.OK.name());
        response.setData(userEntities);
        response.setPageSize(pageSize);
        response.setPageIndex(offset);
        response.setTotalPages(totalPage);
        response.setTotalElements(coutUserRole);

        return response;
    }
}
