/*
 * $Id$
 * Copyright: 
 *
 * Last change:
 * $Date$
 * $Author$
 */
package com.auth.rest.api.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


 /**
 *
 * Description courte de la classe
 *
 * @author mmerabti
 * @since 7 juin 2016.  API version : 1.0
 * @version 1.0
 * 
 *	{@inheritDoc}				
 */
@Provider
public class BusinessExceptionMapper implements ExceptionMapper<BusinessException> {
    public Response toResponse(BusinessException ex) {
        return Response.status(ex.getStatus())
                .entity(ex.getErrorCode())
                .type(MediaType.APPLICATION_JSON).
                build();
    }

}

