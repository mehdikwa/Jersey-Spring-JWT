/**
 * 
 */
package com.auth.rest.api.converters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Two ways abstract class that converts a collection of entities to a collection of DTOs and vice versa
 *
 * Description courte de la classe
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
public abstract class AbstractListConverter<ENTITY, DTO> extends OneWayAbstractListConverter<ENTITY, DTO> implements ListConverter<ENTITY, DTO> {

    /**
     * Convert from a list of business model (dto) to a list of domain model (entity)
     * 
     * @param source
     *            list of dtos
     * @return target list of entities
     */
    public List<ENTITY> convertFrom(Collection<DTO> source) {
        if (source == null) {
            return null;
        }
        List<ENTITY> target = new ArrayList<ENTITY>();
        
        source.forEach(clazz -> target.add(this.convertFrom(clazz)));

        return target;
    }
}
