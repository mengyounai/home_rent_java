package com.example.home_rent.vo.user;


import com.example.home_rent.vo.common.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserCreateVo extends BaseVo {

    @NotNull(message = "username:账户名称不能为空")
    private String username;

    private String nickName;

    @NotNull(message = "password:登录密码不能为空")
    private String password;

    private String phone;

    private Integer status;


}
