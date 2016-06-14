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
 * Password Policy configuration table
 *
 * @author mmerabti
 * @since 10 mai 2016.  API version : 1.0
 * @version 1.0
 * 
 *          {@inheritDoc}
 */

@Entity
@Table(name = "DIRECTORY_PWD_POLICY")
public class PasswordPolicyEntity extends CustomAuditable<String, Integer> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Passord policy id
     */
    @Id
    @SequenceGenerator(name = "POLICY_ID_GENERATOR", sequenceName = "DIRECTORY_PWD_POLICY_S")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POLICY_ID_GENERATOR")
    @Column(name = "POLICY_ID")
    private Integer id;

    /**
     * Minimum password length
     */
    @Column(name = "MIN_LENGTH")
    private Integer minLength;

    /**
     * How many digits must be
     */
    @Column(name = "NB_DIGITS")
    private Integer nbDigits;

    @Column(name = "NB_LOWER_CASES")
    private Integer nbLowerCases;

    @Column(name = "NB_UPPER_CASES")
    private Integer nbUpperCases;

    @Column(name = "NB_SPECIAL_CHARS")
    private Integer nbSpecialChars;

    @Column(name = "NB_DISTINCT_CHARS")
    private Integer nbDistinctChars;

    @Column(name = "MAX_TRIES")
    private Integer maxTries;

    /**
     * null never expires
     */
    @Column(name = "PERIODE_OF_VALIDITY")
    private Integer periodeOfValidity;

    /**
     * null functionality is deactivated
     */
    @Column(name = "REMEMBER_ME")
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
