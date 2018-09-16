package com.abby.user;

import com.abby.mapper.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private PrivilegeMapper privilegeMapper;


    public UserDetailsServiceImp(){

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserExample example=new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<User> users=userMapper.selectByExample(example);
        User user=null;
        if(users!=null&&!users.isEmpty()){
            user=users.get(0);
        }

        //now trying to get the authority of this user
        PrivilegeExample privilegeExample=new PrivilegeExample();
        privilegeExample.createCriteria().andUserIdEqualTo(user.getId());
        List<Privilege> privileges=privilegeMapper.selectByExample(privilegeExample);
        List<GrantedAuthority> authorities=new ArrayList<>();
        for(int i=0;i<privileges.size();i++){
            authorities.add(new SimpleGrantedAuthority(privileges.get(i).getPrivilege()));
        }

        return new UserDetailsImp(user.getPassword(),user.getUsername(),user.getPhone(),user.getEmail(),authorities);
    }
}
