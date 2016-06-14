/**
 * 
 */
package com.auth.rest.api.resources;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auth.rest.api.bom.PasswordPolicyDto;
import com.auth.rest.api.converter.PasswordPolicyConverter;
import com.auth.rest.api.entity.PasswordPolicyEntity;
import com.auth.rest.api.resource.crud.CrudResource;
import com.auth.rest.api.service.PasswordPolicyService;

/**
 *
 * Description courte de la classe
 *
 * @author mmerabti
 * @since 30 mai 2016.  API version : 1.0
 * @version 1.0
 * 
 *          {@inheritDoc}
 */

@Component
@Path("/policies")
public class PasswordPolicyResource extends CrudResource<PasswordPolicyDto, PasswordPolicyEntity, PasswordPolicyService, PasswordPolicyConverter> {

    @Autowired
    private PasswordPolicyService passwordPolicyService;

    @Autowired
    private PasswordPolicyConverter passwordPolicyConverter;
    /*
     * (non-Javadoc)
     * 
     * @see fr..rest.api.resource.crud.CrudResourceImpl#getService()
     */
    @Override
    protected PasswordPolicyService getService() {
        return passwordPolicyService;
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr..rest.api.resource.crud.CrudResource#getConverter()
     */
    @Override
    protected PasswordPolicyConverter getConverter() {
        return passwordPolicyConverter;
    }

}