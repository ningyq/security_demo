package com.ningyq.security_demo.security;

import com.ningyq.security_demo.bean.Role;
import com.ningyq.security_demo.bean.User;
import com.ningyq.security_demo.bean.UserRole;
import com.ningyq.security_demo.repository.RoleRepository;
import com.ningyq.security_demo.repository.UserRepository;
import com.ningyq.security_demo.repository.UserRoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Component
public class MyUserDetailsService implements UserDetailsService {

    Logger log = LoggerFactory.getLogger(MyUserDetailsService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = userRepository.findByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("用户名：" + userName + "不存在！");
        }

        String password = user.getPassword();
        log.info(password);

        System.out.println(password);

        List<UserRole> userRoles = userRoleRepository.findUserRolesByUId(user.getId());
        List<Role> roles = new ArrayList<>();
        Collection<SimpleGrantedAuthority> collection = new HashSet<>();

        for (UserRole userRole : userRoles) {
            System.out.println(roleRepository.findRolesById(userRole.getRoleId()).getName());
            collection.add(new SimpleGrantedAuthority(roleRepository.findRolesById(userRole.getRoleId()).getName()));
        }

        return new org.springframework.security.core.userdetails.User(userName, password, user.getEnabled(), true, true, !user.getLocked(), collection);
    }
}
