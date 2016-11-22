package com.isea533.mybatis.service.impl;

import com.github.pagehelper.PageHelper;
import com.isea533.mybatis.model.Country;
import com.isea533.mybatis.model.User;
import com.isea533.mybatis.model.UserProfile;
import com.isea533.mybatis.service.UserProfileService;
import com.isea533.mybatis.service.UserService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

/**
 * @author liuzh_3nofxnp
 * @since 2015-09-19 17:17
 */
@Service("userProfileService")
public class UserProfileServiceImpl extends BaseService<UserProfile> implements UserProfileService {

    @Override
    public List<UserProfile> selectByUser(UserProfile userProfile, int page, int rows) {
        Example example = new Example(Country.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(userProfile.getType())) {
            criteria.andCondition("TYPE", userProfile.getType());
        }
        //分页查询
        PageHelper.startPage(page, rows);
        return selectByExample(example);
    }

}
