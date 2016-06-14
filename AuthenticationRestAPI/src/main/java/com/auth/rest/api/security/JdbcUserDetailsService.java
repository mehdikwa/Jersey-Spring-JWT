/*
 * $Id$
 * Copyright: 
 *
 * Last change:
 * $Date$
 * $Author$
 */
package com.auth.rest.api.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.auth.rest.api.entity.UserEntity;
import com.auth.rest.api.service.UserService;

/**
 *
 * Description courte de la classe
 *
 * @author mmerabti
 * @since 20 mai 2016.  API version : 1.0
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
@Component
public class JdbcUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserAuthorityService userAuthorityService;

    @Override
    public JwtUser loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity = userService.findByUsername(userName);
        if(userEntity == null){
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", userName));
        }
        Collection<? extends GrantedAuthority> authorities = userAuthorityService.getGrantedAuthorities(userEntity.isAdmin());
        
        JwtUser jwtUser = new JwtUser(userEntity.getId(), userEntity.getUsername(), userEntity.getFirstname(), userEntity.getLastname(), userEntity.getPassword(), userEntity.getEmail(), userEntity.getAuthType().name(), userEntity.isAdmin(), authorities, userEntity.isEnabled(),
                userEntity.getLastPasswordResetDate());
        return jwtUser;
    }

}
