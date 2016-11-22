package com.isea533.mybatis.mapper;

import com.isea533.mybatis.model.UserProfile;
import com.isea533.mybatis.model.UserUserProfile;
import com.isea533.mybatis.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserUserProfileMapper extends MyMapper<UserUserProfile> {
    public List<UserProfile> getUserProfileList(@Param("userId") int userId);
}