/**
 * @(#)UserService.java, 5月 20, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.market.sever.service.spi;

import com.market.sever.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * @author u7382548
 */
public interface UserService {
    User findUserByUserEmail(String email);
    User findUserByUserId(long userId);
    User findUserByUserName(String name);
    long registerUser(User user);
    List<User> find(List<Long> user_ids);
    List<User> findByName(String userName);
}