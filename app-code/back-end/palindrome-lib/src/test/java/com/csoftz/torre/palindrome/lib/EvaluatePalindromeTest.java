/*----------------------------------------------------------------------------*/
/* Source File:   EVALUATEPALINDROMETEST.JAVA                                 */
/* Description:   Tests for number palindrome challenge                       */
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
package com.csoftz.torre.palindrome.lib;

import com.csoftz.torre.palindrome.lib.domain.PalindromeInfo;
import com.csoftz.torre.palindrome.lib.utils.PalindromeManager;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests for number palindrome challenge
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Apr.25/2017
 * @since 1.8 (JDK), Apr.25/2017
 */
public class EvaluatePalindromeTest {
    private static PalindromeManager palindromeManager;

    @BeforeClass
    public static void init() {
        palindromeManager = new PalindromeManager();
    }

    @Test
    public void numberIsNotPalindrome() {
        assertEquals(false, palindromeManager.evaluateInfoPalindrome(111));
    }

    @Test
    public void numberIsPalindrome() {
        assertEquals(true, palindromeManager.evaluateInfoPalindrome(585));
    }

    @Test
    public void evaluateTwoNumbersArePalindrome(){
        assertEquals(true, palindromeManager.evaluateInfoPalindrome(7));
        assertEquals(true, palindromeManager.evaluateInfoPalindrome(585));
    }

    @Test
    public void evaluateTwoNumbersAreNotPalindrome() {
        assertEquals(false, palindromeManager.evaluateInfoPalindrome(2));
        assertEquals(false, palindromeManager.evaluateInfoPalindrome(19));
    }

    @Test
    public void evaluateNumberPalindromeInRange1To10Has5Items() {
        List<PalindromeInfo> infoList = palindromeManager.evaluatePalindromeInRange(1, 10);
        assertEquals(5, infoList.size());
    }

    @Test
    public void evaluateNumberPalindromeRangeOneToOneMillionHas19Items(){
        List<PalindromeInfo> infoList = palindromeManager.evaluatePalindromeInRange(1, 1000000);
        assertEquals(19, infoList.size());
    }

    @Test
    public void evaluateInRangeInvalidParameters() {
        List<PalindromeInfo> infoList = palindromeManager.evaluatePalindromeInRange(-1, -1);
        assertEquals(0, infoList.size());

        infoList = palindromeManager.evaluatePalindromeInRange(2, 1);
        assertEquals(0, infoList.size());

        infoList = palindromeManager.evaluatePalindromeInRange(1, 1000001);
        assertEquals(0, infoList.size());

    }
}
