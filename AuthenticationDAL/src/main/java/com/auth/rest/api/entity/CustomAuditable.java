package com.auth.rest.api.entity;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.joda.time.DateTime;
import org.springframework.data.domain.Auditable;

/**
 * Abstract auditable class that contains necessary columns for auditing
 *
 * @param <USER>
 *            the type of the user id
 * 
 * @param <ID>
 *            the type of the entity primary key (id)
 * 
 * @author mmerabti
 * @since 12 mai 2016.  API version : 1.0
 * @version 1.0
 * 
 */
@MappedSuperclass
public abstract class CustomAuditable<USER extends Serializable, ID extends Serializable> implements Auditable<USER, ID> {

    /**
     * 
     */
    private static final long serialVersionUID = 5572970082352112036L;

    /**
     * the user id who creates the entity
     */
    @Column(name = "CREATED_BY")
    private USER createdBy;

    /**
     * the use id that updates the entity
     */
    @Column(name = "LAST_UPDATED_BY")
    private USER lastModifiedBy;

    /**
     * creation date
     */
    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    /**
     * modification date
     */
    @Column(name = "LAST_UPDATE_DATE")
    @Temporal(TemporalType.DATE)
    private Date lastModifiedDate;

    /**
     * Return the user id who creates the entity
     * 
     * @return user Id
     */
    public USER getCreatedBy() {
        return createdBy;
    }

    /**
     * Set the user id who creates the entity
     * 
     * @param createdBy
     *            user id who creates the entity
     */
    public void setCreatedBy(final USER createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Return the user id who updates the entity
     * 
     * @return lastModifiedBy user Id who updates the entity
     */
    public USER getLastModifiedBy() {
        return lastModifiedBy;
    }

    /**
     * Set the user id who updates the entity
     * 
     * @param lastModifiedBy
     *            user id who updates the entity
     */
    public void setLastModifiedBy(final USER lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    /**
     * Return the creation date
     * 
     * @return creation date using joda time
     */
    public DateTime getCreatedDate() {
        return null == createdDate ? null : new DateTime(createdDate);
    }

    /**
     * Set the entity creation date
     * 
     * @param createdDate
     *            entity creation date
     */
    public void setCreatedDate(final DateTime createdDate) {
        this.createdDate = null == createdDate ? null : createdDate.toDate();
    }

    /**
     * Return the entity update date
     * 
     * @return the entity update date using joda time
     */
    public DateTime getLastModifiedDate() {
        return null == lastModifiedDate ? null : new DateTime(lastModifiedDate);
    }

    /**
     * Set the entity update date
     * 
     * @param lastModifiedDate
     *            the entity update date
     */
    public void setLastModifiedDate(final DateTime lastModifiedDate) {
        this.lastModifiedDate = null == lastModifiedDate ? null : lastModifiedDate.toDate();
    }

    /**
     * set the entity id
     * 
     * @param id
     */
    public abstract void setId(ID id);

    /**
     * abstract method to be implemented
     */
    public abstract ID getId();

    /**
     * Must be {@link Transient} in order to ensure that no JPA provider
     * complains because of a missing setter.
     * 
     * @see DATAJPA-622
     * @see org.springframework.data.domain.Persistable#isNew()
     */
    @Override
    @Transient
    public boolean isNew() {
        return null == getId();
    }
}
