/**
 * 
 */
package com.auth.rest.api.bom;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.auth.rest.api.dto.DtoWithID;

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
public class UserDto extends DtoWithID<Integer> implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Integer id;

    private String username;

    private String firstname;

    private String lastname;

    private String password;

    private String email;

    private boolean admin;

    private String authType;

    private List<UserInfoDto> userInfos = new ArrayList<>();

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
        this.id = id;
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

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname
     *            the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname
     *            the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the admin
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * @param admin
     *            the admin to set
     */
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    /**
     * @return the authType
     */
    public String getAuthType() {
        return authType;
    }

    /**
     * @param authType
     *            the authType to set
     */
    public void setAuthType(String authType) {
        this.authType = authType;
    }

    /**
     * @return the userInfos
     */
    public List<UserInfoDto> getUserInfos() {
        return userInfos;
    }

    /**
     * @param userInfos
     *            the userInfos to set
     */
    public void setUserInfos(List<UserInfoDto> userInfos) {
        this.userInfos = userInfos;
    }


}
