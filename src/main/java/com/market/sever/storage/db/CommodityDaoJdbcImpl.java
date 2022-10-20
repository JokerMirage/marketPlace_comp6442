package com.market.sever.storage.db;

import com.market.sever.entity.Commodity;
import com.market.sever.storage.spi.CommodityDao;

import java.util.List;
import com.market.sever.entity.User;
import com.market.sever.storage.spi.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.Optional;
/**
 * @author u7382548
 */
@Repository
public class CommodityDaoJdbcImpl implements CommodityDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Optional<Commodity> getByID(long id) {

        String sql = "Select * from MarketPlace.Commodity where commodity_id = :commodity_id";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("commodity_id", id);
        try {
            Commodity commodity = namedParameterJdbcTemplate.queryForObject(sql,mapSqlParameterSource,ROWMAPPER);
            return Optional.of(commodity);
        }
        catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }

    }

    @Override
    public long addCommodity(Commodity commodity) {
        String sql = "insert into MarketPlace.Commodity (name,price,img_url,description,brand,category,status,belongID) " +
                "values (:name,:price,:img_url,:description,:brand,:category,:status,:belongID)";
        KeyHolder key = new GeneratedKeyHolder();
        MapSqlParameterSource paramMap = new MapSqlParameterSource();
        paramMap.addValue("name", commodity.getName());
        paramMap.addValue("price", commodity.getPrice());
        paramMap.addValue("img_url",commodity.getImg_url());
        paramMap.addValue("description",commodity.getDescription());
        paramMap.addValue("brand",commodity.getBrand());
        paramMap.addValue("category",commodity.getCategory());
        paramMap.addValue("status",0);
        paramMap.addValue("belongID",commodity.getBelongUserID());
        namedParameterJdbcTemplate.update(sql,paramMap,key);
        return key.getKey().intValue();
    }

    @Override
    public List<Commodity> searchByBrand(String brand) {
        String sql = "Select * from MarketPlace.Commodity where brand =:brand";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("brand", brand);
        List<Commodity> commodities = namedParameterJdbcTemplate.query(sql,mapSqlParameterSource,ROWMAPPER);
        return commodities;
    }

    @Override
    public List<Commodity> searchByName(String name) {
        String sql = "Select * from MarketPlace.Commodity where name like :name";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("brand", "%"+name+"%");
        List<Commodity> commodities = namedParameterJdbcTemplate.query(sql,mapSqlParameterSource,ROWMAPPER);
        return commodities;
    }

    @Override
    public List<Commodity> searchByOwnerID(long id) {
        String sql = "Select * from MarketPlace.Commodity where belongID = :belongID";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("belongID", id);
        try {
            List<Commodity> commodities = namedParameterJdbcTemplate.query(sql,mapSqlParameterSource,ROWMAPPER);
            return commodities;
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Commodity> collectByCategory(String category) {
        String sql = "Select * from MarketPlace.Commodity where category = :category";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("category",category);
        try {
            List<Commodity> commodities = namedParameterJdbcTemplate.query(sql,mapSqlParameterSource,ROWMAPPER);
            return commodities;
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public long updateCommodityInfo(Commodity commodity) {
        String sql = "UPDATE Market.Place"+
                "SET name=:name, price =:price, img_url=:img_url,description=:description,brand=:brand,category=:category,belongID=:belongID"
                + "WHERE commodity_id = :id";
        MapSqlParameterSource paramMap = new MapSqlParameterSource();
        paramMap.addValue("id", commodity.getCommodity_id());
        paramMap.addValue("name", commodity.getName());
        paramMap.addValue("name", commodity.getName());
        paramMap.addValue("price", commodity.getPrice());
        paramMap.addValue("img_url",commodity.getImg_url());
        paramMap.addValue("description",commodity.getDescription());
        paramMap.addValue("brand",commodity.getBrand());
        paramMap.addValue("category",commodity.getCategory());
        paramMap.addValue("belongID",commodity.getBelongUserID());
        int result = namedParameterJdbcTemplate.update(sql,paramMap);
        return result;
    }

    private static final RowMapper<Commodity> ROWMAPPER= (ResultSet rs, int rowNum)->{
        Commodity commodity = new Commodity();
        commodity.setCommodity_id(rs.getLong("commodity_id"));
        commodity.setName(rs.getString("name"));
        commodity.setPrice(rs.getDouble("price"));
        commodity.setImg_url(rs.getString("img_url"));
        commodity.setDescription(rs.getString("description"));
        commodity.setBrand(rs.getString("brand"));
        commodity.setCategory(rs.getString("category"));
        commodity.setBelongUserID(rs.getLong("belongID"));
        return commodity;
    };
}
