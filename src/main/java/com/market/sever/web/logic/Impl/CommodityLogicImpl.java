package com.market.sever.web.logic.Impl;

import com.market.sever.config.CommonResult;
import com.market.sever.entity.Commodity;
import com.market.sever.entity.User;
import com.market.sever.service.spi.CommodityService;
import com.market.sever.web.logic.spi.CommodityLogic;
import com.market.sever.web.vo.CommodityVO;
import com.market.sever.web.wrapper.CommodityVOWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 * @author u7382548
 */
@Service
public class CommodityLogicImpl implements CommodityLogic {
    @Autowired
    CommodityService commodityService;

    @Override
    public Optional<Commodity> findCommodityByID(long id) {
        if(!commodityService.findCommodityByID(id).isPresent()){
            return Optional.empty();
        }
        return Optional.of(commodityService.findCommodityByID(id).get());
    }

    @Override
    public List<Commodity> findCommodityByName(String name) {
        return commodityService.findCommoditiesByName(name);
    }

    @Override
    public List<Commodity> findCommodityByBrand(String brand) {
        return commodityService.findCommoditiesByBrand(brand);
    }

    @Override
    public List<Commodity> findCommodityByCategory(String category) {
        return commodityService.findCommoditiesByCategory(category);
    }

    @Override
    public List<Commodity> findCommodityBybelongID(long belongID) {
        return commodityService.findCommoditiesByOwnerID(belongID);
    }

    @Override
    public long addNewCommodity(String name, double price, String img_url,String description, String category, String brand, long belongID) {
        Commodity commodity = Commodity.builder().name(name)
                .price(price)
                .img_url(img_url)
                .description(description)
                .category(category)
                .brand(brand)
                .belongUserID(belongID)
                .build();
        return commodityService.addNewCommodity(commodity);
    }

    @Override
    public CommonResult updateCommodityInfo(long id, String name, double price,String img_url, String description, String category, String brand, int status, long belongID) {
        Optional<Commodity> commodity = commodityService.findCommodityByID(id);
        if(!commodity.isPresent()){
            return CommonResult.objectNotExist();
        }
        Commodity updatedcommodity = Commodity.builder().commodity_id(id)
                .name(name)
                .price(price)
                .img_url(img_url)
                .description(description)
                .category(category)
                .brand(brand)
                .status(status)
                .belongUserID(belongID)
                .build();
        return commodityService.updateCommodityInfo(updatedcommodity)==1?CommonResult.successWithData(findCommodityByID(id)):
                CommonResult.innerError();

    }
}
