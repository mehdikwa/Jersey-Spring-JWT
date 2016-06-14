/**
 * 
 */
package com.auth.rest.api.converters;

/**
 *
 * One way interface converter that presents a method to convert a domain entity to a business dto
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

public interface OneWayConverter<ENTITY, DTO> {

    /**
     * Convert from a domain model (entity) to the business model (dto)
     * 
     * @param source
     *            entity
     * @return target dto
     */
    public DTO convertTo(ENTITY source);
}
