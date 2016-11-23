package com.isea533.mybatis.springsecurity.configuration;

import com.isea533.mybatis.model.User;
import com.isea533.mybatis.model.UserProfile;
import com.isea533.mybatis.service.UserService;
import com.isea533.mybatis.service.UserUserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2016/11/21.
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserUserProfileService userUserProfileService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userService.selectByUserName(s);
        System.out.println(" user : " + user);
        if(user == null){
            System.out.println("User " + s + " not found ");
            throw new UsernameNotFoundException("User " + s + " not found ");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                "Avtive".equals(user.getState()), true, true, true, getGrantedAuthorities(user));

    }

    private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for(UserProfile userProfile : userUserProfileService.getUserProfileList(user.getId())){
            System.out.println("UserProfile : " + userProfile);
            authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType()));
        }
        System.out.println("authorities : " + authorities);
        return authorities;
    }

}
