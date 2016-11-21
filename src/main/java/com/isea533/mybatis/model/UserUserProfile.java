package com.isea533.mybatis.model;

import javax.persistence.*;

@Table(name = "user_user_profile")
public class UserUserProfile {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "USER_ID")
    private Integer userId;

    @Column(name = "USER_PROFILE_ID")
    private Integer userProfileId;

    /**
     * @return ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return USER_ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return USER_PROFILE_ID
     */
    public Integer getUserProfileId() {
        return userProfileId;
    }

    /**
     * @param userProfileId
     */
    public void setUserProfileId(Integer userProfileId) {
        this.userProfileId = userProfileId;
    }
}