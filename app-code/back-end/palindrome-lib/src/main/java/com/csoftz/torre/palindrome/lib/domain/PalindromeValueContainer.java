/*----------------------------------------------------------------------------*/
/* Source File:   PALINDROMEVALUECONTAINER.JAVA                               */
/* Description:   Keeps information about evaluated number range to evaluate  */
/*                if there are palindromes in there.                          */
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

import java.util.ArrayList;
import java.util.List;

/**
 * Keeps information about evaluated number range to evaluate
 * if there are palindromes in there.
 *
 * The rule to observe is that both then number and is binary representation must
 * be palindromes, e.g. num=585 is palindrome and its binary representation is
 * 1001001001 which is also palindrome. But the num=111 is palindrome but
 * its binary representation 1101111 is not.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Apr.25/2017
 * @since 1.8 (JDK), Apr.25/2017
 */
public class PalindromeValueContainer {
    private Integer x;
    private Integer y;
    private List<PalindromeInfo> palindromes;
    private Integer numOfPalindromes;

    public PalindromeValueContainer() {
        this.x = 0;
        this.y = 0;
        this.palindromes = new ArrayList<PalindromeInfo>();
        this.numOfPalindromes = 0;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public List<PalindromeInfo> getPalindromes() {
        return palindromes;
    }

    public void setPalindromes(List<PalindromeInfo> palindromes) {
        this.palindromes = palindromes;
    }

    @Override
    public String toString() {
        return "PalindromeValueContainer{" +
                "x=" + x +
                ", y=" + y +
                ", palindromes=" + palindromes +
                ", numOfPalindromes=" + numOfPalindromes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PalindromeValueContainer that = (PalindromeValueContainer) o;

        if (!x.equals(that.x)) return false;
        if (!y.equals(that.y)) return false;
        if (!palindromes.equals(that.palindromes)) return false;
        return numOfPalindromes.equals(that.numOfPalindromes);
    }

    @Override
    public int hashCode() {
        int result = x.hashCode();
        result = 31 * result + y.hashCode();
        result = 31 * result + palindromes.hashCode();
        result = 31 * result + numOfPalindromes.hashCode();
        return result;
    }

    public Integer getNumOfPalindromes() {

        return numOfPalindromes;
    }

    public void setNumOfPalindromes(Integer numOfPalindromes) {
        this.numOfPalindromes = numOfPalindromes;
    }

}
