package com.sky.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "添加新用户模块")
public class EmployeeDTO implements Serializable {

    @ApiModelProperty("用户id")
    private Long id;

    @ApiModelProperty("用户名称")
    private String username;

    @ApiModelProperty("用户身份")
    private String name;

    @ApiModelProperty("用户手机号码")
    private String phone;

    @ApiModelProperty("用户性别")
    private String sex;

    @ApiModelProperty("用户身份证")
    private String idNumber;

}
