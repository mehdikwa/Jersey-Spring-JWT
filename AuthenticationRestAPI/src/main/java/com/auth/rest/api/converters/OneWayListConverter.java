/**
 * 
 */
package com.auth.rest.api.converters;

import java.util.Collection;
import java.util.List;

/**
 *
 * One Way interface that presents a method to convert a collection of entities to a collection of DTOs
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

public interface OneWayListConverter<ENTITY, DTO> extends OneWayConverter<ENTITY, DTO> {

    /**
     * Convert from a domain model (entity) list to the business model (dto) list
     * 
     * @param source
     *            list of entities
     * @return target list of dtos
     */
    public List<DTO> convertTo(Collection<ENTITY> source);
}
