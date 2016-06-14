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
 * @since 30 mai 2016.  API version : 1.0
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class PasswordPolicyDto extends DtoWithID<Integer> implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -6414121119430659145L;
    private Integer id;

    private Integer minLength;

    private Integer nbDigits;

    private Integer nbLowerCases;

    private Integer nbUpperCases;

    private Integer nbSpecialChars;

    private Integer nbDistinctChars;

    private Integer maxTries;

    private Integer periodeOfValidity;

    private boolean remeberMe;

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
     * @return the minLength
     */
    public Integer getMinLength() {
        return minLength;
    }

    /**
     * @param minLength
     *            the minLength to set
     */
    public void setMinLength(Integer minLength) {
        this.minLength = minLength;
    }

    /**
     * @return the nbDigits
     */
    public Integer getNbDigits() {
        return nbDigits;
    }

    /**
     * @param nbDigits
     *            the nbDigits to set
     */
    public void setNbDigits(Integer nbDigits) {
        this.nbDigits = nbDigits;
    }

    /**
     * @return the nbLowerCases
     */
    public Integer getNbLowerCases() {
        return nbLowerCases;
    }

    /**
     * @param nbLowerCases
     *            the nbLowerCases to set
     */
    public void setNbLowerCases(Integer nbLowerCases) {
        this.nbLowerCases = nbLowerCases;
    }

    /**
     * @return the nbUpperCases
     */
    public Integer getNbUpperCases() {
        return nbUpperCases;
    }

    /**
     * @param nbUpperCases
     *            the nbUpperCases to set
     */
    public void setNbUpperCases(Integer nbUpperCases) {
        this.nbUpperCases = nbUpperCases;
    }

    /**
     * @return the nbSpecialChars
     */
    public Integer getNbSpecialChars() {
        return nbSpecialChars;
    }

    /**
     * @param nbSpecialChars
     *            the nbSpecialChars to set
     */
    public void setNbSpecialChars(Integer nbSpecialChars) {
        this.nbSpecialChars = nbSpecialChars;
    }

    /**
     * @return the nbDistinctChars
     */
    public Integer getNbDistinctChars() {
        return nbDistinctChars;
    }

    /**
     * @param nbDistinctChars
     *            the nbDistinctChars to set
     */
    public void setNbDistinctChars(Integer nbDistinctChars) {
        this.nbDistinctChars = nbDistinctChars;
    }

    /**
     * @return the maxTries
     */
    public Integer getMaxTries() {
        return maxTries;
    }

    /**
     * @param maxTries
     *            the maxTries to set
     */
    public void setMaxTries(Integer maxTries) {
        this.maxTries = maxTries;
    }

    /**
     * @return the periodeOfValidity
     */
    public Integer getPeriodeOfValidity() {
        return periodeOfValidity;
    }

    /**
     * @param periodeOfValidity
     *            the periodeOfValidity to set
     */
    public void setPeriodeOfValidity(Integer periodeOfValidity) {
        this.periodeOfValidity = periodeOfValidity;
    }

    /**
     * @return the remeberMe
     */
    public boolean isRemeberMe() {
        return remeberMe;
    }

    /**
     * @param remeberMe
     *            the remeberMe to set
     */
    public void setRemeberMe(boolean remeberMe) {
        this.remeberMe = remeberMe;
    }

}
