/**
 * @(#)UseDao.java, 5月 20, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.market.sever.storage.spi;

import com.market.sever.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * @author u7382548
 */
public interface UserDao {

    long add(User user);
    User find(String email);
    User findByUserName(String username);
    User find(long id);

    List<User> findByName(String userName);

    List<User> find(List<Long> user_ids);
}