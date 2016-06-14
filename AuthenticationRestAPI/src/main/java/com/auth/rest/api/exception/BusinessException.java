package com.auth.rest.api.exception;

import javax.ws.rs.WebApplicationException;

/**
 * 
 *
 * Description courte de la classe
 *
 * @author mmerabti
 * @since 2 juin 2016.  API version : 1.0
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class BusinessException extends WebApplicationException {
    /**
     * serialUid
     */
    private static final long serialVersionUID = -8229837850658777788L;
    
    private int status;

    private BusinessErrorCode errorCode;

    /**
     * Construit un objet <code>BusinessException</code>.
     * 
     * @param errorCode
     * @param message
     */
    public BusinessException(BusinessErrorCode errorCode, String message) {
        super(message);
        this.setErrorCode(errorCode);
    }

    /**
     * @return the errorCode
     */
    public BusinessErrorCode getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode
     *            the errorCode to set
     */
    public void setErrorCode(BusinessErrorCode errorCode) {
        this.errorCode = errorCode;
    }
    

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}