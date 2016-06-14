/**
 * 
 */
package com.auth.rest.api.converter;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auth.rest.api.bom.UserDto;
import com.auth.rest.api.converters.AbstractListConverter;
import com.auth.rest.api.entity.AuthTypeEnum;
import com.auth.rest.api.entity.UserEntity;
import com.auth.rest.api.service.UserService;

/**
 *
 * Description courte de la classe
 *
 * @author mmerabti
 * @since 12 mai 2016.  API version : 1.0
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
@Component
public class UserConverter extends AbstractListConverter<UserEntity, UserDto> {

    @Autowired
    private UserService userService;

    @Autowired
    private UserInfoConverter userInfoConverter;

    /*
     * (non-Javadoc)
     * 
     * @see fr..rest.api.converters.OneWayConverter#convertTo(java.lang.Object)
     */
    @Override
    public UserDto convertTo(UserEntity source) {
        if (source == null) {
            return null;
        }

        UserDto target = new UserDto();
        target.setId(source.getId());
        target.setPassword(source.getPassword());
        target.setUsername(source.getUsername());
        target.setLastname(source.getLastname());
        target.setFirstname(source.getFirstname());
        target.setEmail(source.getEmail());
        target.setAdmin(source.isAdmin());
        target.setAuthType(source.getAuthType().name());
        target.setUserInfos(userInfoConverter.convertTo(source.getUserInfos()));

        return target;
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr..rest.api.converters.Converter#convertFrom(java.lang.Object)
     */
    @Override
    public UserEntity convertFrom(UserDto source) {
        if (source == null) {
            return null;
        }

        UserEntity target = null;
        if (source.getId() != null) {
            target = userService.findById(source.getId());
        } else {
            target = new UserEntity();
        }

        target.setPassword(source.getPassword());
        target.setUsername(source.getUsername());
        target.setLastname(source.getLastname());
        target.setFirstname(source.getFirstname());
        target.setEmail(source.getEmail());
        target.setAdmin(source.isAdmin());
        target.setAuthType(AuthTypeEnum.valueOf(source.getAuthType()));
        target.setUserInfos(new HashSet<>(userInfoConverter.convertFrom(source.getUserInfos())));

        return target;
    }

}
