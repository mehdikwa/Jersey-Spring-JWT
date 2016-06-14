/**
 * 
 */
package com.auth.rest.api.bom;

import java.io.Serializable;

import com.auth.rest.api.dto.DtoWithID;

/**
 *
 * Description courte de la classe
 *
 * @author mmerabti
 * @since 19 mai 2016.  API version : 1.0
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class UserInfoDto extends DtoWithID<Integer> implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Integer id;

    private String key;

    private String value;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
        this.id = id;
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
