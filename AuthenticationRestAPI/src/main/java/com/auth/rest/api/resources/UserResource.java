package com.auth.rest.api.resources;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auth.rest.api.bom.UserDto;
import com.auth.rest.api.exception.BusinessException;
import com.auth.rest.api.manager.UserManager;
import com.auth.rest.api.security.ClaimKeyEnum;
import com.auth.rest.api.security.JwtTokenUtil;


/**
 * 
 *
 * Description courte de la classe
 *
 * @author mmerabti
 * @since 30 mai 2016.  API version : 1.0
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
@Component
@Path("/users")
public class UserResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserResource.class);

    @Autowired
    private UserManager userManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(UserDto dto, @Context HttpServletRequest httpRequest) throws BusinessException {

        String username = (String) jwtTokenUtil.getClaimValueFromRequest(ClaimKeyEnum.CLAIM_KEY_USERNAME, httpRequest);
        dto = userManager.createUser(dto, username);
        return Response.status(Response.Status.CREATED).type(MediaType.APPLICATION_JSON).entity(dto).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") Integer id) {
        UserDto dto = null;
        try {
            dto = userManager.getUser(id);
        } catch (BusinessException e) {
            LOGGER.error(e.getMessage(), e);
            return Response.status(Response.Status.NOT_FOUND).entity(e.getErrorCode()).build();
        }
        return Response.status(Response.Status.OK).entity(dto).build();
    }
}
