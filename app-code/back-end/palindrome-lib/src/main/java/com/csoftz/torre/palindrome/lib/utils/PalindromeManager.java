/*----------------------------------------------------------------------------*/
/* Source File:   PALINDROMEMANAGER.JAVA                                      */
/* Description:   Utility to manipulate palindrome numbers                    */
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
package com.csoftz.torre.palindrome.lib.utils;

import com.csoftz.torre.palindrome.lib.domain.PalindromeInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility to manipulate palindrome numbers
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Apr.25/2017
 * @since 1.8 (JDK), Apr.25/2017
 */
public class PalindromeManager {

    /**
     * Given the string verifies if it is a palindrome
     *
     * @param s Data
     * @return True if palindrome
     */
    public boolean isPalindromeString(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    /**
     * Evaluates if the data contained which means if is a string representation of a number
     * and its binary representation is both palindromes.
     *
     * @param number Data to evaluate
     * @return True if the string number representation is palindrome and its binary number
     * representation is palindrome.
     */
    public boolean evaluateInfoPalindrome(Integer number) {
        return isPalindromeString(Integer.toString(number)) &&
                isPalindromeString(Integer.toBinaryString(number));
    }

    /**
     * Returns a list of Palindrome Numbers (both decimal and binary number must be a palindrome).
     * The evaluation happens in the range x through y, and both x and y must be integer and x <= y.
     * <p>
     * Given a range of numbers in (x..y) where x <= y and valid integer values.
     * <p>
     * 1 <= x <= 1000000
     * 1 <= y <= 1000000
     *
     * @param x Range start
     * @param y Range End
     * @return If x > y then an empty list is returned. If any parameter is
     * outside range then and empty list is returned as well.
     */
    public List<PalindromeInfo> evaluatePalindromeInRange(Integer x, Integer y) {
        List<PalindromeInfo> palindromeInfoList = new ArrayList<PalindromeInfo>();

        boolean rangeStart = (x >= 1 && x <= 1000000);
        boolean rangeEnd = (x >= 1 && y <= 1000000);
        if (rangeStart && rangeEnd) {
            while (x <= y) {
                if (evaluateInfoPalindrome(x)) {
                    palindromeInfoList.add(new PalindromeInfo(Integer.toString(x), Integer.toBinaryString(x)));
                }
                x++;
            }
        }
        return palindromeInfoList;
    }
}
