package com.example.home_rent.controller;

import com.alibaba.fastjson.JSON;
import com.example.home_rent.constants.ReturnCode;
import com.example.home_rent.dto.BaseUserInfo;
import com.example.home_rent.exception.ServiceException;
import com.example.home_rent.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Component
public class BaseController {

    @Resource
    HttpServletRequest request;


    protected BaseUserInfo getBaseInfo() {
        BaseUserInfo userInfo;
        try {
            String accessToken = request.getHeader("token");
            Claims claims = new JwtUtil().decode(accessToken);
            userInfo = JSON.parseObject(JSON.toJSONString(claims), BaseUserInfo.class);
        } catch (Exception ignored) {
            throw new ServiceException(ReturnCode.token_expired_code, "token失效请重新登录");
        }
        return userInfo;
    }



}
