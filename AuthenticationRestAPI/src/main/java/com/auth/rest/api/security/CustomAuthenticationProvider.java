/**
 * 
 */
package com.auth.rest.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.ldap.authentication.LdapAuthenticationProvider;
import org.springframework.stereotype.Component;

import com.auth.rest.api.entity.AuthTypeEnum;
import com.auth.rest.api.entity.UserEntity;
import com.auth.rest.api.service.UserService;

/**
 * 
 *
 * Description courte de la classe
 *
 * @author mmerabti
 * @since 13 avril 2016.
 * @version 1.0
 * 
 *	{@inheritDoc}
 */

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    @Qualifier("ldapAuthProvider")
    private LdapAuthenticationProvider ldapAuthProvider;

    @Autowired
    @Qualifier("daoAuthProvider")
    private DaoAuthenticationProvider daoAuthProvider;

    @Autowired
    private UserService userService;

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.authentication.AuthenticationProvider#authenticate(org.springframework.security.core.Authentication)
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        UserEntity userEntity = userService.findByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        }
        AuthTypeEnum authType = userEntity.getAuthType();
        switch (authType) {
        case SIMPLE:
            return daoAuthProvider.authenticate(authentication);
        case LDAP:
            return ldapAuthProvider.authenticate(authentication);
        default:
            throw new IllegalArgumentException(authType + " is not yet implemented!");
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.authentication.AuthenticationProvider#supports(java.lang.Class)
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

}
