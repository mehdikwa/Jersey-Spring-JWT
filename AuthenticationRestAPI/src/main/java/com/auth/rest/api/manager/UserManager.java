package com.auth.rest.api.manager;

import com.auth.rest.api.bom.UserDto;
import com.auth.rest.api.exception.BusinessException;

/**
 * 
 *
 * Description courte de la classe
 *
 * @author mmerabti
 * @since 2 juin 2016.  API version : 1.0
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public interface UserManager {

    public UserDto createUser(UserDto dto, String username) throws BusinessException;

    public UserDto getUser(Integer id) throws BusinessException;

}
