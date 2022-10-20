package com.market.sever.web.ctrl;

import com.market.sever.config.CommonResult;
import com.market.sever.web.logic.spi.UserLogic;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

/**
 * @author u7382548
 */
@Slf4j
@RestController
@RequestMapping(value = "/market/api/user")
public class MainController {

    @Autowired
    public UserLogic userLogic;

    @Autowired
    public HttpServletRequest httpServletRequest;

    @ApiOperation("根据userId查询用户")
    @GetMapping(value = "/id")
    public CommonResult getUserByUserId(@RequestParam("user_id")long userId) {
        return CommonResult.successWithData(userLogic.findUserByUserId(userId));

    }

    @ApiOperation("根据email查询用户")
    @GetMapping(value = "/email")
    public CommonResult getUserByUserId(@RequestParam("email")String email) {
        return CommonResult.successWithData(userLogic.findUserByUserVOEmail(email));
    }

    @ApiOperation("根据user name查询用户")
    @GetMapping(value = "/name")
    public CommonResult getUserByUserName(@RequestParam("username")String userName) {
        return userLogic.findByName(userName).isEmpty()
                ?CommonResult.objectNotExist()
                :CommonResult.successWithData(userLogic.findByName(userName));
    }

    @ApiOperation("验证账号密码")
    @GetMapping(value = "/login")
    public CommonResult logIn(@RequestParam("username")String username, @RequestParam("password")String password){
        return userLogic.logIn(username,password);
    }

    @ApiOperation("注册账号")
    @PostMapping(value = "/register")
    public CommonResult registerUser(@RequestParam("user_name")String userName, @RequestParam("password") String password,
                                 @RequestParam("email")String email){
        return CommonResult.successWithData(userLogic.findUserByUserId(userLogic.registerUser(userName,password,email)));
    }
}