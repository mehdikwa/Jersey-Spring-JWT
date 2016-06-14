/**
 * 
 */
package com.auth.rest.api.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auth.rest.api.bom.UserInfoDto;
import com.auth.rest.api.converters.AbstractListConverter;
import com.auth.rest.api.entity.UserInfoEntity;
import com.auth.rest.api.service.UserInfoService;

/**
 *
 * Description courte de la classe
 *
 * @author mmerabti
 * @since 19 mai 2016.  API version : 1.0
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
@Component
public class UserInfoConverter extends AbstractListConverter<UserInfoEntity, UserInfoDto> {

    @Autowired
    private UserInfoService userInfoService;

    /*
     * (non-Javadoc)
     * 
     * @see fr..rest.api.converters.OneWayConverter#convertTo(java.lang.Object)
     */
    @Override
    public UserInfoDto convertTo(UserInfoEntity source) {
        if (source == null) {
            return null;
        }
        UserInfoDto target = new UserInfoDto();
        target.setId(source.getId());
        target.setKey(source.getKey());
        target.setValue(source.getValue());
        return target;
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr..rest.api.converters.Converter#convertFrom(java.lang.Object)
     */
    @Override
    public UserInfoEntity convertFrom(UserInfoDto source) {
        if (source == null) {
            return null;
        }
        UserInfoEntity target = null;

        if (source.getId() != null) {
            target = userInfoService.findById(source.getId());
        } else {
            target = new UserInfoEntity();
        }

        target.setKey(source.getKey());
        target.setValue(source.getValue());
        return target;
    }

}
