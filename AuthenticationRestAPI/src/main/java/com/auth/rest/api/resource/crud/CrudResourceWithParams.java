package com.auth.rest.api.resource.crud;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.auth.rest.api.converters.ListConverter;
import com.auth.rest.api.dto.DtoWithID;
import com.auth.rest.api.entity.CustomAuditable;
import com.auth.rest.api.service.BaseService;


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

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public abstract class CrudResourceWithParams<DTO extends DtoWithID<Integer>, ENTITY extends CustomAuditable<Integer, Integer>, SERVICE extends BaseService<ENTITY>, CONVERTER extends ListConverter<ENTITY, DTO>>{
    
    /**
     * 
     * @param pageNumber
     * @param maxResult
     * @param sortDirection
     * @return
     */
    @GET
    public Page<ENTITY> getAll(Pageable pageRequest) {
        Page<ENTITY> entities = this.getService().findAll(pageRequest);
        return entities;
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


}
