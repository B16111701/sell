package com.imooc.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class OrderForm {

    @NotEmpty(message = "openid必填")
    private String openid;

    @NotEmpty(message = "购物车不为空")
    private String items;
}
