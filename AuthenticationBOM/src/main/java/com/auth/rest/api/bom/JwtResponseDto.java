package com.auth.rest.api.bom;

import java.io.Serializable;

/**
 * 
 *
 * Description courte de la classe
 *
 * @author mmerabti
 * @since 20 mai 2016.  API version : 1.0
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class JwtResponseDto implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;

    public JwtResponseDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
