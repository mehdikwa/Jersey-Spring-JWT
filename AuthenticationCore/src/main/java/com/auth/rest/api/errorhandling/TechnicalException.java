/**
 * 
 */
package com.auth.rest.api.errorhandling;

/**
 *
 * La classe <code>TechnicalException</code> represents a technical exception.
 *
 * @author mmerabti
 * @since 2 juin 2016.  API version : 1.0
 * @version 1.0
 * 
 *          {@inheritDoc}
 */

public class TechnicalException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = -8316324009963694711L;

    private TechnicalErrorCode errorCode;


    /**
     * Construit un objet <code>TechnicalException</code>.
     * 
     * @param source
     *            l'exception source
     */
    public TechnicalException(TechnicalErrorCode errorCode, Throwable source) {
        super(source);
        this.setErrorCode(errorCode);
    }

    /**
     * Construit un objet <code>TechnicalException</code>.
     * 
     * @param errorCode
     * @param message
     */
    public TechnicalException(TechnicalErrorCode errorCode, String message) {
        super(message);
        this.setErrorCode(errorCode);
    }

    /**
     * @return the errorCode
     */
    public TechnicalErrorCode getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode
     *            the errorCode to set
     */
    public void setErrorCode(TechnicalErrorCode errorCode) {
        this.errorCode = errorCode;
    }

}
