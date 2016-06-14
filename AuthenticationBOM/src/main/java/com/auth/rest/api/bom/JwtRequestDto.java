package com.auth.rest.api.bom;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * 
 *
 * Description courte de la classe
 *
 * @author mmerabti
 * @since 20 mai 2016. 
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class  JwtRequestDto implements Serializable {

    private static final long serialVersionUID = -8445943548965154778L;

    @NotNull(message = "username.missing")
    private String username;

    @NotNull(message = "password.missing")
    private String password;

    public JwtRequestDto() {
        super();
    }

    public JwtRequestDto(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     *            the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
