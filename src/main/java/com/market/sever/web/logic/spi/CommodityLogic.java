package com.market.sever.web.logic.spi;

import com.market.sever.config.CommonResult;
import com.market.sever.entity.Commodity;
import com.market.sever.web.vo.CommodityVO;


import java.util.List;
import java.util.Optional;

public interface CommodityLogic {
    Optional<Commodity> findCommodityByID(long id);
    List<Commodity> findCommodityByName(String name);
    List<Commodity> findCommodityByBrand(String brand);
    List<Commodity> findCommodityByCategory(String category);
    List<Commodity> findCommodityBybelongID(long belongID);
    long addNewCommodity(String name,double price,String img_url, String description, String category, String brand,long belongID);
    CommonResult updateCommodityInfo(long id,String name,double price,String img_url, String description, String category, String brand,int status,long belongID);

}
