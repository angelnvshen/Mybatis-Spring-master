package com.isea533.mybatis.service.impl;

import com.github.pagehelper.PageHelper;
import com.isea533.mybatis.mapper.UserUserProfileMapper;
import com.isea533.mybatis.model.Country;
import com.isea533.mybatis.model.UserProfile;
import com.isea533.mybatis.model.UserUserProfile;
import com.isea533.mybatis.service.UserProfileService;
import com.isea533.mybatis.service.UserUserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

/**
 * @author liuzh_3nofxnp
 * @since 2015-09-19 17:17
 */
@Service("userUserProfileService")
public class UserUserProfileServiceImpl extends BaseService<UserUserProfile> implements UserUserProfileService {

    @Autowired
    private UserUserProfileMapper userUserProfileMapper;
    
    @Override
    public List<UserUserProfile> selectByUser(UserUserProfile userUserProfile, int page, int rows) {
        Example example = new Example(Country.class);
        Example.Criteria criteria = example.createCriteria();
        if (userUserProfile.getUserId() != null) {
            criteria.andCondition("USER_ID", userUserProfile.getUserId());
        }
        if (userUserProfile.getUserProfileId() != null) {
            criteria.andCondition("USER_PROFILE_ID", userUserProfile.getUserProfileId());
        }
        //分页查询
        PageHelper.startPage(page, rows);
        return selectByExample(example);
    }

    @Override
    public List<UserProfile> getUserProfileList(int userId){
        return userUserProfileMapper.getUserProfileList(userId);
    }
}
