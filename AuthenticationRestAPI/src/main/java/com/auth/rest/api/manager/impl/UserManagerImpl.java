/**
 * 
 */
package com.auth.rest.api.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.auth.rest.api.bom.UserDto;
import com.auth.rest.api.converter.UserConverter;
import com.auth.rest.api.entity.UserEntity;
import com.auth.rest.api.exception.BusinessException;
import com.auth.rest.api.exception.UserManagementErrorCode;
import com.auth.rest.api.manager.UserManager;
import com.auth.rest.api.service.UserService;

/**
 *
 * Description courte de la classe
 *
 * @author mmerabti
 * @since 2 juin 2016.  API version : 1.0
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
@Service
public class UserManagerImpl implements UserManager {

    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    @Qualifier("passwordEncoder")
    private BCryptPasswordEncoder passwordEncoder;

    /*
     * (non-Javadoc)
     * 
     * @see fr..vkauthentication.rest.api.manager.UserManager#createUser(fr..vkauthentication.bom.UserDto, java.lang.String)
     */
    @Override
    public UserDto createUser(UserDto dto, String username) throws BusinessException {

        if (StringUtils.isEmpty(dto.getAuthType())) {
            throw new BusinessException(UserManagementErrorCode.AUTH_TYPE_MISSING, "auth type is missing");
        }
        if (StringUtils.isEmpty(dto.getEmail())) {
            throw new BusinessException(UserManagementErrorCode.EMAIL_MISSING, "email is missing");
        }

        if (StringUtils.isEmpty(dto.getFirstname())) {
            throw new BusinessException(UserManagementErrorCode.FIRST_NAME_MISSING, "first name is missing");
        }

        if (StringUtils.isEmpty(dto.getLastname())) {
            throw new BusinessException(UserManagementErrorCode.LAST_NAME_MISSING, "last name is missing");
        }

        if (StringUtils.isEmpty(dto.getUsername())) {
            throw new BusinessException(UserManagementErrorCode.USER_NAME_MISSING, "username is missing");
        }

        // convert to entity in order to save
        UserEntity userEntity = userConverter.convertFrom(dto);
        // encode passsword before saving
        String password = passwordEncoder.encode(dto.getPassword());
        userEntity.setPassword(password);
        userEntity = userService.save(userEntity, username);
        // update dto
        dto = userConverter.convertTo(userEntity);
        return dto;
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr..vkauthentication.rest.api.manager.UserManager#getUser(java.lang.Integer)
     */
    @Override
    public UserDto getUser(Integer id) throws BusinessException {
        UserEntity entity = userService.findById(id);
        if (entity == null) {
            throw new BusinessException(UserManagementErrorCode.USER_NOT_FOUND, "user not found " + id);
        }
        UserDto dto = userConverter.convertTo(entity);
        return dto;
    }

}
