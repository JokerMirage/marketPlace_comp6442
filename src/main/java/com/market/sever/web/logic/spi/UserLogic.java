package com.market.sever.web.logic.spi;

import com.market.sever.config.CommonResult;
import com.market.sever.entity.User;
import com.market.sever.web.vo.UserVO;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author u7382548
 */
public interface UserLogic {
    User findUserByUserId(long userId);
    User findUserByUserEmail(String email);
    public Optional<UserVO> findUserByUserVOName(String name);
    public Optional<UserVO> findUserByUserVOEmail(String email);
    List<User> findByName(String userName);
    CommonResult logIn(String username, String password);
    long registerUser( String user_name, String password,String email);
}