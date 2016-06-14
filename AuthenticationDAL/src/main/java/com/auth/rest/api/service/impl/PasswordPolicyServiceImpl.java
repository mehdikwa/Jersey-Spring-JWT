/**
 * 
 */
package com.auth.rest.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.rest.api.dao.PasswordPolicyDao;
import com.auth.rest.api.entity.PasswordPolicyEntity;
import com.auth.rest.api.service.PasswordPolicyService;

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
public class PasswordPolicyServiceImpl extends BaseServiceImpl<PasswordPolicyEntity, PasswordPolicyDao> implements PasswordPolicyService {

    @Autowired
    private PasswordPolicyDao passwordPolicyDao;

    /*
     * (non-Javadoc)
     * 
     * @see fr..vkconnect.service.impl.BaseServiceImpl#getDaoLayer()
     */
    @Override
    protected PasswordPolicyDao getDaoLayer() {
        return passwordPolicyDao;
    }

}
