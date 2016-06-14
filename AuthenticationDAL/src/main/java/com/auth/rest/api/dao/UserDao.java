/**
 * 
 */
package com.auth.rest.api.dao;

import java.util.Optional;

import com.auth.rest.api.entity.UserEntity;

/**
 *
 * Description courte de la classe
 *
 * @author mmerabti
 * @since 9 mai 2016.  API version : 1.0
 * @version 1.0
 * 
 *          {@inheritDoc}
 */

public interface UserDao extends AbstractDao<UserEntity> {

    Optional<UserEntity> findByUsername(String userName);
    
}
