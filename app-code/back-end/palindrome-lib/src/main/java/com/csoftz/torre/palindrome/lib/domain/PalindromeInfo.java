/*----------------------------------------------------------------------------*/
/* Source File:   PALINDROMEINFO.JAVA                                         */
/* Description:   Given an integer number, stores the string representation   */
/*                out of it as well its binary representation.                */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Apr.25/2017                                                 */
/* Last Modified: Apr.25/2017                                                 */
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
 * @version 1.1, Apr.25/2017
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PalindromeInfo that = (PalindromeInfo) o;

        if (!number.equals(that.number)) return false;
        return numberAsBinary.equals(that.numberAsBinary);
    }

    @Override
    public int hashCode() {
        int result = number.hashCode();
        result = 31 * result + numberAsBinary.hashCode();
        return result;
    }

    public String getNumberAsBinary() {
        return numberAsBinary;
    }

    public void setNumberAsBinary(String numberAsBinary) {
        this.numberAsBinary = numberAsBinary;
    }

    @Override
    public String toString() {
        return "PalindromeInfo{" +
                "number='" + number + '\'' +
                ", numberAsBinary='" + numberAsBinary + '\'' +
                '}';
    }
}
