package com.isea533.mybatis.service;

import com.isea533.mybatis.model.Country;
import com.isea533.mybatis.model.User;

import java.util.List;

/**
 * @author liuzh_3nofxnp
 * @since 2015-09-19 17:17
 */
public interface UserService extends IService<User> {

    /**
     * 根据条件分页查询
     *
     * @param user
     * @param page
     * @param rows
     * @return
     */
    List<User> selectByUser(User user, int page, int rows);

    User selectByUserName(String userName);
}
