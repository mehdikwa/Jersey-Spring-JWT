/**
 * 
 */
package com.auth.rest.api.converters;

import java.util.Collection;
import java.util.List;

/**
 *
 * Two ways interface that presents a method that converts a collection of entities to a collection of DTOs and vice versa
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
public interface ListConverter<ENTITY, DTO> extends OneWayListConverter<ENTITY, DTO>, Converter<ENTITY, DTO> {
    /**
     * Convert from a business model (dto) list to the domain model (entity) list
     * 
     * @param source
     *            list of dtos
     * @return target list of entities
     */
    public List<ENTITY> convertFrom(Collection<DTO> source);
}
