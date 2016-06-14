/**
 * 
 */
package com.auth.rest.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.rest.api.dao.UserInfoDao;
import com.auth.rest.api.entity.UserInfoEntity;
import com.auth.rest.api.service.UserInfoService;

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
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfoEntity, UserInfoDao> implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    /*
     * (non-Javadoc)
     * 
     * @see fr..vkconnect.service.impl.BaseServiceImpl#getDaoLayer()
     */
    @Override
    protected UserInfoDao getDaoLayer() {
        return userInfoDao;
    }

}
