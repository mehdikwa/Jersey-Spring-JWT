/**
 * 
 */
package com.auth.rest.api.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
 * @param <ENTITY>
 * @param <USER>
 * @param <ID>
 */

public interface BaseService<ENTITY> {

    ENTITY save(ENTITY entity, String user);

    List<ENTITY> save(Iterable<ENTITY> entities, String user);

    ENTITY findById(Integer id);

    void deleteById(Integer id, String user);

    void delete(Iterable<Integer> ids, String user);

    List<ENTITY> findAll();

    List<ENTITY> findAll(Iterable<Integer> ids);
    
    Page<ENTITY> findAll(Pageable pageRequest);

    long count();
}
