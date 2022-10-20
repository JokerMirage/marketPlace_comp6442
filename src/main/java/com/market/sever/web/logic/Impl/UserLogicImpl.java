package com.market.sever.web.logic.Impl;

import com.market.sever.config.CommonResult;
import com.market.sever.entity.TokenUtil;
import com.market.sever.entity.User;
import com.market.sever.service.spi.UserService;
import com.market.sever.web.logic.spi.UserLogic;
import com.market.sever.web.vo.UserVO;
import com.market.sever.web.wrapper.UserVOWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author u7382548
 */
@Service
public class UserLogicImpl implements UserLogic {
    @Autowired
    UserService userService;

    @Override
    public User findUserByUserId(long userId){
        return userService.findUserByUserId(userId);
    }

    @Override
    public User findUserByUserEmail(String email) {

        return userService.findUserByUserEmail(email);
    }

    @Override
    public Optional<UserVO> findUserByUserVOName(String name) {
        return Optional.of(UserVOWrapper.wrapper(userService.findUserByUserName(name)));
    }

    @Override
    public Optional<UserVO> findUserByUserVOEmail(String email) {
        return Optional.of(UserVOWrapper.wrapper(userService.findUserByUserEmail(email)));
    }

    @Override
    public List<User> findByName(String userName) {
        return userService.findByName(userName);
    }

    @Override
    public CommonResult logIn(String username, String password) {
        User user = userService.findUserByUserName(username);
        if(user.getEmail()==null){
            return CommonResult.objectNotExist();
        }
        if(password.equals(user.getPsw())){
            CommonResult cr = new CommonResult();
            TokenUtil tokenUtil = new TokenUtil();
            cr.setToken(tokenUtil.getToken(username));
            //System.out.println(cr.getToken());
            cr.setData(findUserByUserVOName(username));
            cr.setCode(200);
            cr.setMessage("Successfully login");
            return cr;
        }else return CommonResult.result(401,"Account or password does not match",null);
//        return password.equals(user.get().getPsw())?CommonResult.successWithData(findUserByUserVOEmail(email))
//                                                        :CommonResult.result(401,"Account or password does not match",null);
    }

    @Override
    public long registerUser(String user_name, String password, String email) {
        User user = User.builder().userName(user_name)
                .email(email)
                .userId(0)
                .psw(password).build();
        return userService.registerUser(user);
    }


}