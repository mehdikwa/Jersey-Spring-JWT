/**
 * 
 */
package com.auth.rest.api.security;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

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
public class UserAuthorityService {

    public Collection<? extends GrantedAuthority> getGrantedAuthorities(boolean isAdmin) {

        Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        if (isAdmin) {
            authorities.add(new SimpleGrantedAuthority("ADMIN"));
        }
        authorities.add(new SimpleGrantedAuthority("USER"));
        return authorities;
    }
}
