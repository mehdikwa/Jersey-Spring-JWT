/**
 * 
 */
package com.auth.rest.api.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auth.rest.api.bom.PasswordPolicyDto;
import com.auth.rest.api.converters.AbstractListConverter;
import com.auth.rest.api.entity.PasswordPolicyEntity;
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
public class PasswordPolicyConverter extends AbstractListConverter<PasswordPolicyEntity, PasswordPolicyDto> {

    @Autowired
    private PasswordPolicyService passwordPolicyService;

    /*
     * (non-Javadoc)
     * 
     * @see fr..rest.api.converters.OneWayConverter#convertTo(java.lang.Object)
     */
    @Override
    public PasswordPolicyDto convertTo(PasswordPolicyEntity source) {
        if (source == null) {
            return null;
        }
        PasswordPolicyDto target = new PasswordPolicyDto();
        target.setId(source.getId());
        target.setMaxTries(source.getMaxTries());
        target.setMinLength(source.getMinLength());
        target.setNbDigits(source.getNbDigits());
        target.setNbDistinctChars(source.getNbDistinctChars());
        target.setNbUpperCases(source.getNbUpperCases());
        target.setNbLowerCases(source.getNbLowerCases());
        target.setNbSpecialChars(source.getNbSpecialChars());
        target.setPeriodeOfValidity(source.getPeriodeOfValidity());
        target.setRemeberMe(source.isRemeberMe());

        return target;
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr..rest.api.converters.Converter#convertFrom(java.lang.Object)
     */
    @Override
    public PasswordPolicyEntity convertFrom(PasswordPolicyDto source) {
        if (source == null) {
            return null;
        }
        PasswordPolicyEntity target = null;
        if (source.getId() != null) {
            passwordPolicyService.findById(source.getId());
        } else {
            target = new PasswordPolicyEntity();
        }

        target.setMaxTries(source.getMaxTries());
        target.setMinLength(source.getMinLength());
        target.setNbDigits(source.getNbDigits());
        target.setNbDistinctChars(source.getNbDistinctChars());
        target.setNbUpperCases(source.getNbUpperCases());
        target.setNbLowerCases(source.getNbLowerCases());
        target.setNbSpecialChars(source.getNbSpecialChars());
        target.setPeriodeOfValidity(source.getPeriodeOfValidity());
        target.setRemeberMe(source.isRemeberMe());

        return target;
    }

}
