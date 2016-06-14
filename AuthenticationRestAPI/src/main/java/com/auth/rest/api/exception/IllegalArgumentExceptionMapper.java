/*
 * $Id$
 * Copyright: 
 *
 * Last change:
 * $Date$
 * $Author$
 */
package com.auth.rest.api.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;


 /**
 *
 * Description courte de la classe
 *
 * @author mmerabti
 * @since 9 juin 2016.  API version : 1.0
 * @version 1.0
 * 
 *	{@inheritDoc}				
 */

public class IllegalArgumentExceptionMapper implements ExceptionMapper<IllegalArgumentException>{

    /* (non-Javadoc)
     * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
     */
    @Override
    public Response toResponse(IllegalArgumentException e) {
        Response.Status status = Response.Status.BAD_REQUEST;
        return Response.status(status).entity(e.getMessage()).build();
      }

}
