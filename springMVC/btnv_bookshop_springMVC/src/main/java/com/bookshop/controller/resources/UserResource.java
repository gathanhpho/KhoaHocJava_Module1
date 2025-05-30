package com.bookshop.controller.resources;

import com.bookshop.entity.UserEntity;
import com.bookshop.model.response.PageResponse;
import com.bookshop.service.UserService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserResource {

    private UserService userService;

    public UserResource(UserService userService) {this.userService = userService;}

    @GetMapping(value = "/user", produces = "application/json")
    public ResponseEntity<PageResponse<List<UserEntity>>> getAll(@RequestParam(name = "pageSize") Long pageSize,
                                                   @RequestParam(name = "pageIndex") Long pageIndex,
                                                   @RequestParam(name = "user_name", required = false) String userName,
                                                   @RequestParam(name = "role_name", required = false) String roleName) {
        PageResponse<List<UserEntity>> userModel = userService.getUserRole(pageSize, pageIndex, userName, roleName);
        ResponseEntity<PageResponse<List<UserEntity>>> response = new ResponseEntity<>(userModel, HttpStatus.OK);
        return response;
    }
}
