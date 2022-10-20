/**
 * @(#)UserVOWrapper.java, 5月 20, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.market.sever.web.wrapper;

import com.market.sever.entity.User;
import com.market.sever.web.vo.UserVO;

/**
 * @author u7382548
 */
public class UserVOWrapper {

    public static UserVO wrapper (User user){
        if (user == null){
            return null;
        }

        UserVO vo = UserVO.builder().userId(user.getUserId())
                .email(user.getEmail())
                .userName(user.getUserName()).build();
        return vo;
    }
}