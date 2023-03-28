package com.example.home_rent.service;


import com.example.home_rent.dto.BaseUserInfo;
import com.example.home_rent.dto.user.UserDTO;
import com.example.home_rent.po.User;
import com.example.home_rent.vo.user.LoginVo;
import com.example.home_rent.vo.user.UserCreateVo;

public interface UserService {

    User checkUser(String username, String password);

    User findUser(String userName);

    UserDTO login(LoginVo loginVo);

    User addUser(UserCreateVo createVo);

    UserDTO userInfo(BaseUserInfo baseUserInfo);

}
