/**
 * 
 */
package com.auth.rest.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * Description courte de la classe
 *
 * @author mmerabti
 * @since 18 mai 2016.  API version : 1.0
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
@Entity
@Table(name = "DIRECTORY_USER_INFOS")
public class UserInfoEntity extends CustomAuditable<String, Integer> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "INFO_ID_GENERATOR", sequenceName = "DIRECTORY_USER_INFOS_S")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INFO_ID_GENERATOR")
    @Column(name = "INFO_ID")
    private Integer id;

    @Column(name = "KEY")
    private String key;

    @Column(name = "VALUE")
    private String value;

    /*
     * (non-Javadoc)
     * 
     * @see fr..rest.api.entity.CustomAuditable#setId(java.io.Serializable)
     */
    @Override
    public void setId(Integer id) {
        this.id = id;

    }

    /*
     * (non-Javadoc)
     * 
     * @see fr..rest.api.entity.CustomAuditable#getId()
     */
    @Override
    public Integer getId() {
        return id;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key
     *            the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value
     *            the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }


}
