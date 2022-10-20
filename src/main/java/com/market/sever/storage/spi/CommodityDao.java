package com.market.sever.storage.spi;

import com.market.sever.entity.Commodity;

import java.util.List;
import java.util.Optional;
/**
 * @author u7382548
 */
public interface CommodityDao {
    Optional<Commodity> getByID(long id);
    long addCommodity(Commodity commodity);
    List<Commodity> searchByBrand(String brand);
    List<Commodity> searchByName(String name);
    List<Commodity> searchByOwnerID(long id);
    List<Commodity> collectByCategory(String category);
    long updateCommodityInfo(Commodity commodity);

}
