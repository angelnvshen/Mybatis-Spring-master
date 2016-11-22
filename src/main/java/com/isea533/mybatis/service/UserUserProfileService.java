package com.isea533.mybatis.service;

import com.isea533.mybatis.model.UserProfile;
import com.isea533.mybatis.model.UserUserProfile;

import java.util.List;

/**
 * @author liuzh_3nofxnp
 * @since 2015-09-19 17:17
 */
public interface UserUserProfileService extends IService<UserUserProfile> {

    /**
     * 根据条件分页查询
     *
     * @param userUserProfile
     * @param page
     * @param rows
     * @return
     */
    List<UserUserProfile> selectByUser(UserUserProfile userUserProfile, int page, int rows);

    List<UserProfile> getUserProfileList( int userId);
}
