/**
 * 
 */
package com.auth.rest.api.exception;

/**
 *
 * Description courte de la classe
 *
 * @author mmerabti
 * @since 2 juin 2016.  API version : 1.0
 * @version 1.0
 * 
 *          {@inheritDoc}
 */

public enum UserManagementErrorCode implements BusinessErrorCode {
    AUTH_TYPE_MISSING("users.auth_type.missing"),
    EMAIL_MISSING("users.email.missing"),
    FIRST_NAME_MISSING("users.firstname.missing"),
    LAST_NAME_MISSING("users.lastname.missing"),
    USER_NAME_MISSING("users.username.missing"),
    USER_NOT_FOUND("users.not_found");

    private final String value;

    /**
     * @param value
     */
    private UserManagementErrorCode(String value) {
        this.value = value;
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr..rest.api.errorhandling.BusinessErrorCode#getValue()
     */
    @Override
    public String getValue() {
        return value;
    }

}
