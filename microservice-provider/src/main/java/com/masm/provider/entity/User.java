package com.masm.provider.entity;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * Created by simple on 2017/5/29.
 */
public class User {

    @ApiModelProperty(value = "主键", hidden = false, notes = "主键，隐藏", required = true, dataType = "Integer")
    //使用该注解描述是属性信息，当hidden=true时，该属性不会在api中显示
    private int id;
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "姓名")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @ApiModelProperty(value = "年龄")
    private int age;
    @ApiModelProperty(value = "收入")
    private BigDecimal balance;


}
