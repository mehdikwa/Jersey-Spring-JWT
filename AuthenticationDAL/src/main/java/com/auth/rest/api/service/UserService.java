/**
 * 
 */
package com.auth.rest.api.service;

import com.auth.rest.api.entity.UserEntity;

/**
 *
 * Description courte de la classe
 *
 * @author mmerabti
 * @since 10 mai 2016.  API version : 1.0
 * @version 1.0
 * 
 *	{@inheritDoc}				
 */

public interface UserService extends BaseService<UserEntity> {

    UserEntity findByUsername(String username);
}
