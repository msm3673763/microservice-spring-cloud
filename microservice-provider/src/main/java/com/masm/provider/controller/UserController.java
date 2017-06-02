package com.masm.provider.controller;

import com.masm.provider.entity.User;
import com.masm.provider.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by simple on 2017/5/29.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "根据主键获取用户信息", notes = "根据id获取用户信息")//使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "user表id", required = true, dataType = "Integer", paramType = "path")
    })//使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path,否则在UI中访问接口方法时会报错
    //paramType表示参数的类型，可选的值有：path、body、query、header、form
    @GetMapping("/findById/{id}")
    public User findById(@PathVariable int id) {
        System.out.println("************************consumer call*****************************");
        return userService.findById(id);
    }

}
