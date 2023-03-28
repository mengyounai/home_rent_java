package com.example.home_rent.dto;

import lombok.Data;

@Data
public class BaseUserInfo {

    protected Integer userId;

    protected String userName;

    protected Integer userType;

    protected Integer isAdmin;
}
