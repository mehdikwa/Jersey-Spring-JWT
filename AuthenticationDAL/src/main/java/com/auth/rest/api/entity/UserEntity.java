/**
 * 
 */
package com.auth.rest.api.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * Description courte de la classe
 *
 * @author mmerabti
 * @since 9 mai 2016.  API version : 1.0
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
@Entity
@Table(name = "DIRECTORY_USERS")
public class UserEntity extends CustomAuditable<String, Integer> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "USER_ID_GENERATOR", sequenceName = "DIRECTORY_USERS_S")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ID_GENERATOR")
    @Column(name = "USER_ID")
    private Integer id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "FIRST_NAME")
    private String firstname;

    @Column(name = "LAST_NAME")
    private String lastname;

    @Column(name = "ADMIN_FLAG")
    private boolean admin = false;

    @Enumerated(EnumType.STRING)
    @Column(name = "AUTH_TYPE")
    private AuthTypeEnum authType;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private Set<UserInfoEntity> userInfos;

    @Column(name = "ACTIVE_FLAG")
    private boolean enabled = true;

    @Column(name = "LAST_PASSWORD_RESET_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPasswordResetDate;

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
    public AuthTypeEnum getAuthType() {
        return authType;
    }

    /**
     * @param authType
     *            the authType to set
     */
    public void setAuthType(AuthTypeEnum authType) {
        this.authType = authType;
    }

    /**
     * @return the userInfos
     */
    public Set<UserInfoEntity> getUserInfos() {
        return userInfos;
    }

    /**
     * @param userInfos
     *            the userInfos to set
     */
    public void setUserInfos(Set<UserInfoEntity> userInfos) {
        this.userInfos = userInfos;
    }

    /**
     * @return the enabled
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * @param enabled
     *            the enabled to set
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * @return the lastPasswordResetDate
     */
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    /**
     * @param lastPasswordResetDate
     *            the lastPasswordResetDate to set
     */
    public void setLastPasswordResetDate(Date lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }


}
