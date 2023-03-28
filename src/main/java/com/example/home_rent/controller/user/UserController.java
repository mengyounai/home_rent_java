package com.example.home_rent.controller.user;


import com.example.home_rent.constants.ReturnCode;
import com.example.home_rent.controller.BaseController;
import com.example.home_rent.dto.BaseUserInfo;
import com.example.home_rent.dto.user.UserDTO;
import com.example.home_rent.po.User;
import com.example.home_rent.service.UserService;
import com.example.home_rent.util.ResponseUtils;
import com.example.home_rent.vo.user.LoginVo;
import com.example.home_rent.vo.user.UserCreateVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/user")
@CrossOrigin
public class UserController extends BaseController {

    @Resource
    UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public ResponseUtils<UserDTO> getBaseSettingInfo(@RequestBody LoginVo loginVo) {
        UserDTO userDTO = null;
        try {
            userDTO = userService.login(loginVo);
        } catch (Exception e) {
            return new ResponseUtils<>(ReturnCode.error_code, "登录失败:"+e.getMessage());
        }
        return new ResponseUtils<>(ReturnCode.success_code, "登录成功", userDTO);
    }


    //创建
    @PostMapping("/register")
    public ResponseUtils<Long> createUser(@Valid @RequestBody UserCreateVo createVo) {
        User userModel = userService.addUser(createVo);
        return new ResponseUtils<>(ReturnCode.success_code,"注册成功",userModel.getId());
    }

    //查询用户信息
    @GetMapping("/info")
    public ResponseUtils<UserDTO> userInfo() {
        UserDTO userDTO = userService.userInfo(getBaseInfo());
        return new ResponseUtils<>(ReturnCode.success_code,"查询成功",userDTO);
    }
//
//    //更新
//    @PostMapping("/update")
//    @NoRepeatSubmit
//    @UserAction(comment = "用户更新")
//    public ResponseUtils<Integer> updateUser(@Valid @RequestBody UserUpdateVo updateVo) {
//        UserModel userModel = userBusiness.updateUser(updateVo, getBaseInfo());
//        return new ResponseUtils<>(ReturnCode.success_code, "修改成功", userModel.getId());
//    }
//
//    //用户信息
//    @GetMapping("/info")
//    public ResponseUtils<UserDetailDTO> getUserInfo() {
//        UserQueryDetailVo userQueryDetailVo = new UserQueryDetailVo();
//        userQueryDetailVo.setUserId(getBaseInfo().getUserId());
//        userQueryDetailVo.setPartitionId(getBaseInfo().getPartitionId());
//        UserDetailDTO userDetailDTO = userBusiness.getUserInfo(userQueryDetailVo, this.getBaseInfo());
//        userDetailDTO.setPartitionId(getBaseInfo().getPartitionId());
//        userDetailDTO.setPartitionName(getBaseInfo().getPartitionName());
//        return new ResponseUtils<>(userDetailDTO);
//    }















}
