/**
 * 
 */
package com.auth.rest.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.rest.api.dao.UserDao;
import com.auth.rest.api.entity.UserEntity;
import com.auth.rest.api.service.UserService;

/**
 *
 * Description courte de la classe
 *
 * @author mmerabti
 * @since 11 mai 2016.  API version : 1.0
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserEntity, UserDao> implements UserService {

    @Autowired
    private UserDao userDao;

    /*
     * (non-Javadoc)
     * 
     * @see fr..vkconnect.service.impl.BaseServiceImpl#getDaoLayer()
     */
    @Override
    protected UserDao getDaoLayer() {
        return userDao;
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr..vkconnect.service.UserService#findByUserName(java.lang.String)
     */
    @Override
    public UserEntity findByUsername(String username) {
        return userDao.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("username must not be null nor empty"));
    }

}
