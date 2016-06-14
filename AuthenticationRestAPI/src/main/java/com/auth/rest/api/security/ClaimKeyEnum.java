/**
 * 
 */
package com.auth.rest.api.security;


 /**
 *
 * Description courte de la classe
 *
 * @author mmerabti
 * @since 3 juin 2016.  API version : 1.0
 * @version 1.0
 * 
 *	{@inheritDoc}				
 */

public enum ClaimKeyEnum {
    CLAIM_KEY_USERID("id"),
    CLAIM_KEY_USERNAME("username"),
    CLAIM_KEY_CREATED("created"),
    CLAIM_KEY_NAME("name"),
    CLAIM_KEY_ADMIN("admin"),
    CLAIM_KEY_AUTH_TYPE("auttype"),
    CLAIM_KEY_EMAIL("email");

    private final String value;

    /**
     * @param value
     */
    private ClaimKeyEnum(String value) {
        this.value = value;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

}
