package com.market.sever.service.Impl;

import com.market.sever.entity.Commodity;
import com.market.sever.service.spi.CommodityService;
import com.market.sever.storage.spi.CommodityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 * @author u7382548
 */
@Service
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    CommodityDao commodityDao;

    @Override
    public Optional<Commodity> findCommodityByID(long commodity_id) {
        return commodityDao.getByID(commodity_id);
    }

    @Override
    public List<Commodity> findCommoditiesByBrand(String brand) {
        return commodityDao.searchByBrand(brand);
    }

    @Override
    public List<Commodity> findCommoditiesByName(String name) {
        return commodityDao.searchByName(name);
    }

    @Override
    public List<Commodity> findCommoditiesByCategory(String category) {
        return commodityDao.collectByCategory(category);
    }

    @Override
    public List<Commodity> findCommoditiesByOwnerID(long ownerID) {
        return commodityDao.searchByOwnerID(ownerID);
    }

    @Override
    public long addNewCommodity(Commodity commodity) {
        return commodityDao.addCommodity(commodity);
    }

    @Override
    public long updateCommodityInfo(Commodity commodity) {
        return commodityDao.updateCommodityInfo(commodity);
    }
}
