package com.market.sever;

import com.market.sever.entity.User;
import com.market.sever.service.Impl.UserServiceImpl;
import com.market.sever.service.spi.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MarketApplicationTests {
    UserService userService;
    long userID;
    String userName = "XuanTest";
    String email = "XuanTest@email.com";
    String psw = "test";
    @Test
    void addUserTest() {
        User user = new User();
        user.setUserName(userName);
        user.setEmail(email);
        user.setPsw(psw);
        userService.registerUser(user);

    }

    @Test
    void findUserTest(){
        User usr = userService.findUserByUserEmail("XuanTest@email.com");
        userID = usr.getUserId();

    }

}
