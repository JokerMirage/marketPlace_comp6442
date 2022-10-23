package com.market.sever;

import com.market.sever.entity.Commodity;
import com.market.sever.entity.User;
import com.market.sever.service.Impl.CommodityServiceImpl;
import com.market.sever.service.Impl.UserServiceImpl;
import com.market.sever.service.spi.CommodityService;
import com.market.sever.service.spi.UserService;
import com.market.sever.storage.db.CommodityDaoJdbcImpl;
import com.market.sever.storage.db.UserDaoJdbcTemplateImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class MarketApplicationTests {
//    @Autowired
//    UserDaoJdbcTemplateImpl userService = new UserDaoJdbcTemplateImpl();
//    @Autowired
//    CommodityDaoJdbcImpl commodityService = new CommodityDaoJdbcImpl();
//    String commodity_name = "Test";
//    String img_url = "test";
//    String description = "test";
//    String brand = "test";
//    String category = "test";
//    double price = 10.2;
//    long belongID = 4;
//    int status = 0;
//
//    long commodity_id;
//    long userID;
//    String userName = "XuanTest";
//    String email = "XuanTest@email.com";
//    String psw = "test";
//
//    @Test
//    void addUserTest() {
//        User user = new User();
//        user.setUserName(userName);
//        user.setEmail(email);
//        user.setPsw(psw);
//        userService.add(user);
//
//    }
//
//    @Test
//    void findUserTest(){
//        User usr = userService.find(email);
//        userID = usr.getUserId();
//        Assertions.assertEquals(usr.getEmail(),email);
//        Assertions.assertEquals(usr.getPsw(),psw);
//    }
//
//    @Test
//    void addCommodityTest(){
//        Commodity commodity = new Commodity();
//        commodity.setName(commodity_name);
//        commodity.setCategory(category);
//        commodity.setImg_url(img_url);
//        commodity.setStatus(status);
//        commodity.setBrand(brand);
//        commodity.setDescription(description);
//        commodity.setPrice(price);
//        commodity.setBelongUserID(belongID);
//        commodity_id = commodityService.addCommodity(commodity);
//    }
//
//    @Test
//    void getCommodityTest(){
//        Optional<Commodity> commodity = commodityService.getByID(commodity_id);
//        Commodity commo = commodity.get();
//        Assertions.assertEquals(commo.belongUserID,belongID);
//        Assertions.assertEquals(commo.price,price);
//        Assertions.assertEquals(commo.status,status);
//        Assertions.assertEquals(commo.description,description);
//        Assertions.assertEquals(commo.brand,brand);
//        Assertions.assertEquals(commo.img_url,img_url);
//        Assertions.assertEquals(commo.category,category);
//        Assertions.assertEquals(commo.name,commodity_name);
//    }
}
