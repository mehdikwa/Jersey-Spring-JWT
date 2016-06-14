/**
 * 
 */
package com.auth.rest.api.security;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * Description courte de la classe
 *
 * @author mmerabti
 * @since 12 mai 2016.  API version : 1.0
 * @version 1.0
 * 
 *          {@inheritDoc}
 */

public class JwtUser implements UserDetails {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private final Integer id;
    private final String username;
    private final String firstname;
    private final String lastname;
    private final String password;
    private final String authtype;
    private final String email;
    private final Collection<? extends GrantedAuthority> authorities;
    private final boolean enabled;
    private final boolean admin;
    private final Date lastPasswordResetDate;

    public JwtUser(Integer id, String username, String firstname, String lastname, String password, String email, String authtype, boolean admin, Collection<? extends GrantedAuthority> authorities, boolean enabled, Date lastPasswordResetDate) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.authtype = authtype;
        this.authorities = authorities;
        this.admin = admin;
        this.enabled = enabled;
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the authtype
     */
    public String getAuthtype() {
        return authtype;
    }

    /**
     * @return the authorities
     */
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /**
     * @return the enabled
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * @return the admin
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * @return the lastPasswordResetDate
     */
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


}
