package com.isea533.mybatis.service.impl;

import com.github.pagehelper.PageHelper;
import com.isea533.mybatis.model.Country;
import com.isea533.mybatis.model.User;
import com.isea533.mybatis.service.CountryService;
import com.isea533.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

/**
 * @author liuzh_3nofxnp
 * @since 2015-09-19 17:17
 */
@Service("userService")
public class UserServiceImpl extends BaseService<User> implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> selectByUser(User user, int page, int rows) {
        Example example = new Example(Country.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(user.getUserName())) {
            criteria.andLike("userName", "%" + user.getUserName() + "%");
        }
        if (StringUtil.isNotEmpty(user.getState())) {
            criteria.andLike("state", "%" + user.getState() + "%");
        }
        //分页查询
        PageHelper.startPage(page, rows);
        return selectByExample(example);
    }

    @Override
    public User selectByUserName(String userName){
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("userName", userName);
        List<User> lst = selectByExample(example);
        if(lst.size() == 1)
            return lst.get(0);
        return  null;
    }

    @Override
    public int save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return super.save(user);
    }

}
