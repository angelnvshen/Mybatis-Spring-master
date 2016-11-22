/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.isea533.mybatis.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isea533.mybatis.common.enumState.UserProfileType;
import com.isea533.mybatis.mapper.CountryMapper;
import com.isea533.mybatis.model.Country;
import com.isea533.mybatis.model.User;
import com.isea533.mybatis.model.UserProfile;
import com.isea533.mybatis.service.UserProfileService;
import com.isea533.mybatis.service.UserService;
import com.isea533.mybatis.service.UserUserProfileService;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzh on 2015/3/7.
 */
public class PageMapperTest extends BasicTest {

//    @Autowired
//    private CountryMapper countryMapper;

    @Autowired
    private SqlSession sqlSession;

    @Autowired
    private UserService userService;

    @Autowired
    private UserUserProfileService userUserProfileService;

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void test(){
        CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);
        Example example = new Example(Country.class);
        example.createCriteria().andGreaterThan("id",100);
        PageHelper.startPage(2,10);
        List<Country> countries = countryMapper.selectByExample(example);
        PageInfo<Country> pageInfo = new PageInfo<Country>(countries);
        System.out.println(pageInfo.getTotal());

        countries = countryMapper.selectByExample(example);
        pageInfo = new PageInfo<Country>(countries);
        System.out.println(pageInfo.getTotal());
    }

    @Test
    public void testUser(){
        User user2 = userService.selectByUserName("meng");


        String[] names = {"meng","admin","dba"};

        /*for(int i = 0;i<3;i++) {
            User user = new User();
            user.setEmail("xx.com");
            user.setPassword("123456");
            user.setUserName(names[i]);
            userService.save(user);
        }


        for(UserProfileType type : UserProfileType.values()){
            UserProfile userProfile = new UserProfile();
            userProfile.setType(type.getUserProfileType());
            userProfileService.save(userProfile);
        }*/
        List<UserProfile> lst = userUserProfileService.getUserProfileList(2);
        System.out.println(lst);

        for(int i=0;i<3;i++)
            System.out.println(passwordEncoder.encode("123456"));
    }
}
