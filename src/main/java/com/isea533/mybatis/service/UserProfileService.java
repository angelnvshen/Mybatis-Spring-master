package com.isea533.mybatis.service;

import com.isea533.mybatis.model.User;
import com.isea533.mybatis.model.UserProfile;

import java.util.List;

/**
 * @author liuzh_3nofxnp
 * @since 2015-09-19 17:17
 */
public interface UserProfileService extends IService<UserProfile> {

    /**
     * 根据条件分页查询
     *
     * @param userProfile
     * @param page
     * @param rows
     * @return
     */
    List<UserProfile> selectByUser(UserProfile userProfile, int page, int rows);

}
