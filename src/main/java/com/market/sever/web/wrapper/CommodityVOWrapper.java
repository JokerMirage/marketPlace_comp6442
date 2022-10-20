package com.market.sever.web.wrapper;

import com.market.sever.entity.Commodity;
import com.market.sever.web.vo.CommodityVO;

import java.util.Optional;
/**
 * @author u7382548
 */
public class CommodityVOWrapper {
    public static CommodityVO wrapper(Commodity commodity){
        if(commodity==null){
            return null;
        }

        CommodityVO commodityVO = CommodityVO.builder()
                .commodityID(commodity.getCommodity_id())
                .commodityName(commodity.getName())
                .price(commodity.getPrice())
                .img_url(commodity.getImg_url())
                .description(commodity.getDescription())
                .brand(commodity.getBrand())
                .category(commodity.getCategory())
                .status(commodity.getStatus())
                .belongID(commodity.getBelongUserID())
                .build();
        return commodityVO;
    }
}
