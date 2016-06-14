/**
 * 
 */
package com.auth.rest.api.converters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * One way Abstract class that converts a collection of entities to a collection of DTOs
 *
 * @author mmerabti
 * @since 12 mai 2016.  API version : 1.0
 * @version 1.0
 * 
 * @param <ENTITY>
 *            the domain model type
 * @param <DTO>
 *            the business object type
 */
public abstract class OneWayAbstractListConverter<ENTITY, DTO> implements OneWayListConverter<ENTITY, DTO> {

    /**
     * Convert from a domain model (entity) list to the business model (dto) list
     * 
     * @param source
     *            list of entities
     * @return target list of dtos
     */
    public List<DTO> convertTo(Collection<ENTITY> source) {
        if (source == null) {
            return new ArrayList<DTO>();
        }
        List<DTO> target = new ArrayList<DTO>();
        
        source.forEach(clazz -> target.add(this.convertTo(clazz)));
        return target;

    }
}
