/**
 * 
 */
package com.auth.rest.api.converters;

/**
 *
 * Two ways interface converter that presents two methods to convert a domain entity to a business dto and vice versa
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
public interface Converter<ENTITY, DTO> extends OneWayConverter<ENTITY, DTO> {

    /**
     * Convert from a business model (dto) to the domain model (entity)
     * 
     * @param source
     *            dto
     * @return target entity
     */
    public ENTITY convertFrom(DTO source);
}
