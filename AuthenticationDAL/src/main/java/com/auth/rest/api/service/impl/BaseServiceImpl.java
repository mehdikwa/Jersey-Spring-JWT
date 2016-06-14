/**
 * 
 */
package com.auth.rest.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import com.auth.rest.api.dao.AbstractDao;
import com.auth.rest.api.entity.CustomAuditable;
import com.auth.rest.api.service.BaseService;

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
 * @param <DAO>
 */
public abstract class BaseServiceImpl<ENTITY extends CustomAuditable<String, Integer>, DAO extends AbstractDao<ENTITY>> implements BaseService<ENTITY> {

    @Override
    @Transactional
    public ENTITY save(ENTITY entity, String user) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity must not be null");
        }

        if (user == null) {
            user="hwilliams";
        }

        // check if this is a creation or update
        if (entity.getCreatedBy() == null) {
            entity.setCreatedDate(new DateTime());
        }
        entity.setCreatedBy(user);
        entity.setLastModifiedBy(user);
        entity.setLastModifiedDate(new DateTime());
        return getDaoLayer().save(entity);
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr..rest.api.service.BaseService#save(java.lang.Iterable, java.lang.Object)
     */
    @Override
    @Transactional
    public List<ENTITY> save(Iterable<ENTITY> entities, String user) {
        List<ENTITY> result = new ArrayList<ENTITY>();

        if (entities == null) {
            return result;
        }
        
        entities.forEach(entity -> result.add(save(entity, user)));

        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public ENTITY findById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Cannot find entity with null id");
        }
        return getDaoLayer().findOne(id);
    }

    @Override
    @Transactional
    public void deleteById(Integer id, String user) {
        if (user == null) {
            throw new IllegalArgumentException("UserId must not be null");
        }

        if (id == null) {
            throw new IllegalArgumentException("Cannot delete entity with null id");
        }
        getDaoLayer().delete(id);

    }

    /*
     * (non-Javadoc)
     * 
     * @see fr..rest.api.service.BaseService#delete(java.lang.Iterable, java.lang.Object)
     */
    @Override
    @Transactional
    public void delete(Iterable<Integer> ids, String user) {
       ids.forEach(id -> deleteById(id, user));
    }
    /*
     * (non-Javadoc)
     * 
     * @see fr..vkconnect.service.BaseService#findAll()
     */
    @Override
    @Transactional(readOnly = true)
    public List<ENTITY> findAll() {
        return getDaoLayer().findAll();
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr..rest.api.service.BaseService#count()
     */
    @Override
    public long count() {
        return getDaoLayer().count();
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr..rest.api.service.BaseService#findAll(java.lang.Iterable)
     */
    @Override
    public List<ENTITY> findAll(Iterable<Integer> ids) {
        return getDaoLayer().findAll(ids);
    }
    
    @Override
    public Page<ENTITY> findAll(Pageable request){
        return getDaoLayer().findAll(request);
    }

    protected abstract DAO getDaoLayer();
}
