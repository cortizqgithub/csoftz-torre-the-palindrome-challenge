/*----------------------------------------------------------------------------*/
/* Source File:   PALINDROMEINFO.JAVA                                         */
/* Description:   Given an integer number, stores the string representation   */
/*                out of it as well its binary representation.                */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Apr.25/2017                                                 */
/* Last Modified: Oct.22/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Apr.25/2017 COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.torre.palindrome.lib.domain;

/**
 * Given an integer number, stores the string representation
 * out of it as well its binary representation.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.22/2017
 * @since 1.8 (JDK), Apr.25/2017
 */
public class PalindromeInfo {
    private String number;
    private String numberAsBinary;

    /**
     * Default constructor
     */
    public PalindromeInfo() {
    }

    /**
     * Constructor with parameters
     * @param number
     * @param numberAsBinary
     */
    public PalindromeInfo(String number, String numberAsBinary) {
        this.number = number;
        this.numberAsBinary = numberAsBinary;
    }

    /**
     * Return number
     * @return number to return
     */
    public String getNumber() {
        return number;
    }

    /**
     * Assign number
     * @param number to assign
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Number representation as binary.
     * @return String with binary representation of number.
     */
    public String getNumberAsBinary() {
        return numberAsBinary;
    }

    /**
     * Assign the number as string binary representation.
     * @param numberAsBinary Number to set.
     */
    public void setNumberAsBinary(String numberAsBinary) {
        this.numberAsBinary = numberAsBinary;
    }

    /**
     * Print object representation.
     * @return
     */
    @Override
    public String toString() {
        return "PalindromeInfo{" +
                "number='" + number + '\'' +
                ", numberAsBinary='" + numberAsBinary + '\'' +
                '}';
    }
}
