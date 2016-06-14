package com.auth.rest.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 
 *
 * Interface that extends the {@link JpaRepository} and {@link JpaSpecificationExecutor} to be inherited by entity daos
 * we fixed the type of the id of the entity the repository manages to {@link Integer}
 * 
 * @author mmerabti
 * @since 12 mai 2016.  API version : 1.0
 * @version 1.0
 * 
 * @param <T>
 *            the type of the enity
 */
@NoRepositoryBean
public interface AbstractDao<T> extends JpaRepository<T, Integer> {
}
