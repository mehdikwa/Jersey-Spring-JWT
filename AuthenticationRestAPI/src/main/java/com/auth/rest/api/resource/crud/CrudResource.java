package com.auth.rest.api.resource.crud;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.auth.rest.api.converters.ListConverter;
import com.auth.rest.api.dto.DtoWithID;
import com.auth.rest.api.entity.CustomAuditable;
import com.auth.rest.api.security.ClaimKeyEnum;
import com.auth.rest.api.security.JwtTokenUtil;
import com.auth.rest.api.service.BaseService;

/**
 * 
 *
 * Description courte de la classe
 *
 * @author mmerabti
 * @since 31 mai 2016.  API version : 1.0
 * @version 1.0
 * 
 *          {@inheritDoc}
 * @param <ENTITY>
 * @param <SERVICE>
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public abstract class CrudResource<DTO extends DtoWithID<Integer>, ENTITY extends CustomAuditable<String, Integer>, SERVICE extends BaseService<ENTITY>, CONVERTER extends ListConverter<ENTITY, DTO>> {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /**
     * Returns all instances of the type.
     * 
     * @return all entities
     */
    @GET
    public List<DTO> getAll() {
        List<ENTITY> entities = this.getService().findAll();
        List<DTO> result = getConverter().convertTo(entities);
        return result;
    }
    
    /**
     * Retrieves an entity by its id.
     * 
     * @param id
     *            must not be {@literal null}.
     * @return the entity with the given id or {@literal null} if none found
     * @throws IllegalArgumentException
     *             if {@code id} is {@literal null}
     */
    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") Integer id) {
        ENTITY entity = this.getService().findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        DTO result = getConverter().convertTo(entity);
        return Response.status(Response.Status.OK).entity(result).build();
    }



    /**
     * creates a given entity. Use the returned instance for further operations as the save operation might have changed the
     * entity instance completely.
     * 
     * @param entity
     * @return the saved entity
     */
    @POST
    public Response create(DTO dto, @Context HttpServletRequest httpRequest) {
        ENTITY entity = getConverter().convertFrom(dto);
        entity = this.getService().save(entity, getUserId(httpRequest));
        DTO result = getConverter().convertTo(entity);
        return Response.status(Response.Status.CREATED).entity(result).build();
    }

    /**
     * updates a given entity
     * 
     * @param entity
     * @return
     */
    @PUT
    @Path("/{id}")
    public Response put(@PathParam("id") Integer id, DTO dto, @Context HttpServletRequest httpRequest) {
        ENTITY entity = this.getService().findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        dto.setId(id);
        entity = getConverter().convertFrom(dto);
        entity = this.getService().save(entity, getUserId(httpRequest));
        Response response = Response.status(Response.Status.OK).entity(entity).build();
        return response;
    }





    /**
     * Deletes the entity with the given id.
     * 
     * @param id
     *            must not be {@literal null}.
     * @throws IllegalArgumentException
     *             in case the given {@code id} is {@literal null}
     */

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id, @Context HttpServletRequest httpRequest) {
        ENTITY entity = this.getService().findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        this.getService().deleteById(id, getUserId(httpRequest));
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        return response;
    }

    /**
     * @return
     */
    protected abstract SERVICE getService();

    /**
     * 
     * @return
     */
    protected abstract CONVERTER getConverter();

    /**
     * return authenticated user
     */
    private String getUserId(HttpServletRequest httpRequest) {
        return (String) jwtTokenUtil.getClaimValueFromRequest(ClaimKeyEnum.CLAIM_KEY_USERNAME, httpRequest);
    }
       
}
