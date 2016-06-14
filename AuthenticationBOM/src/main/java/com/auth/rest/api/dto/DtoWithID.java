/**
 * 
 */
package com.auth.rest.api.dto;

import java.io.Serializable;

/**
 *
 * Description courte de la classe
 *
 * @author mmerabti
 * @since 1 juin 2016.  API version : 1.0
 * @version 1.0
 * 
 *          {@inheritDoc}
 */

public abstract class DtoWithID<ID extends Serializable> implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public abstract ID getId();

    public abstract void setId(ID id);
}
