package com.market.sever.service.spi;

import com.market.sever.entity.Commodity;

import java.util.List;
import java.util.Optional;
/**
 * @author u7382548
 */
public interface CommodityService {
    Optional<Commodity> findCommodityByID(long commodity_id);
    List<Commodity> findCommoditiesByBrand(String brand);
    List<Commodity> findCommoditiesByName(String name);
    List<Commodity> findCommoditiesByCategory(String category);
    List<Commodity> findCommoditiesByOwnerID(long ownerID);
    long addNewCommodity(Commodity commodity);
    long updateCommodityInfo(Commodity commodity);

}
