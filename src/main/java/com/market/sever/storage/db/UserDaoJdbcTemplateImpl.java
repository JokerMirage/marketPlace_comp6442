/**
 * @(#)UserDaoImpl.java, 5月 20, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.market.sever.storage.db;

import com.market.sever.entity.User;
import com.market.sever.storage.spi.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

/**
 * @author u7382548
 * @Description This is a class of methods for all APIs realated to user data.
 */
@Slf4j
@Repository
public class UserDaoJdbcTemplateImpl implements UserDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public long add(User user) {
        //Insert into MarketPlace.user(id,username,email,psw) values('2','comp6442@anu.au','comp6442@anu.edu.au','comp6442');
        String sql = "insert into MarketPlace.user (username,email,psw) values (:username, :email, :psw)";
        KeyHolder key = new GeneratedKeyHolder();
        MapSqlParameterSource paramMap = new MapSqlParameterSource();
        paramMap.addValue("username", user.getUserName());
        paramMap.addValue("email", user.getEmail());
        paramMap.addValue("psw",user.getPsw());
        namedParameterJdbcTemplate.update(sql,paramMap,key);
        return key.getKey().intValue();
    }
    @Override
    public User find(long user_id) {
        String sql = "select * from MarketPlace.user where id = :user_id limit 0,1";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("user_id", user_id);
        try {
            User user = namedParameterJdbcTemplate.queryForObject(sql,mapSqlParameterSource,ROWMAPPER);
            return user;
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<User> findByName(String userName) {
        String sql = "select * from MarketPlace.user where username Like :user_name";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("user_name", "%"+userName+"%");
        List<User> users = namedParameterJdbcTemplate.query(sql,mapSqlParameterSource,ROWMAPPER);
        return users;
    }

    @Override
    public List<User> find(List<Long> user_ids) {
        String sql = "select * from MarketPlace.user where id IN (:user_ids)";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("user_ids", user_ids);
        List<User> users = namedParameterJdbcTemplate.query(sql,mapSqlParameterSource,ROWMAPPER);
        return users;
    }

    @Override
    public User find(String email) {
        String sql = "select * from MarketPlace.user where email = :email limit 0,1";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("email", email);
        try {
            User user = namedParameterJdbcTemplate.queryForObject(sql,mapSqlParameterSource,ROWMAPPER);
            return user;
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }

    }

    @Override
    public User findByUserName(String username) {
        String sql = "select * from MarketPlace.user where username = :username limit 0,1";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("username", username);
        try {
            User user = namedParameterJdbcTemplate.queryForObject(sql,mapSqlParameterSource,ROWMAPPER);
            log.info(user.getUserName()+"==="+user.getUserId());
            return user;
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    private static final RowMapper<User> ROWMAPPER= (ResultSet rs, int rowNum)->{
        User user = new User();
        user.setEmail(rs.getString("email"));
        user.setUserId(rs.getInt("id"));
        user.setUserName(rs.getString("username"));
        user.setPsw(rs.getString("psw"));
        user.setDate(rs.getDate("creationTime"));
        return user;
    };
}