/*----------------------------------------------------------------------------*/
/* Source File:   EVALUATEPALINDROMETEST.JAVA                                 */
/* Description:   Tests for number palindrome challenge                       */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Apr.25/2017                                                 */
/* Last Modified: Oct.22/2017                                                 */
/* Version:       1.2                                                         */
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

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for number palindrome challenge
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.2, Oct.22/2017
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
        // Arrange
        // Act
        // Assert
        assertThat(palindromeManager.evaluateInfoPalindrome(111)).isFalse();
    }

    @Test
    public void numberIsPalindrome() {
        // Arrange
        // Act
        // Assert
        assertThat(palindromeManager.evaluateInfoPalindrome(585)).isTrue();
    }

    @Test
    public void evaluateTwoNumbersArePalindrome() {
        // Arrange
        // Act
        // Assert
        assertThat(palindromeManager.evaluateInfoPalindrome(7)).isTrue();
        assertThat(palindromeManager.evaluateInfoPalindrome(585)).isTrue();
    }

    @Test
    public void evaluateTwoNumbersAreNotPalindrome() {
        // Arrange
        // Act
        // Assert
        assertThat(palindromeManager.evaluateInfoPalindrome(2)).isFalse();
        assertThat(palindromeManager.evaluateInfoPalindrome(19)).isFalse();
    }

    @Test
    public void evaluateNumberPalindromeInRange1To10Has5Items() {
        // Arrange
        // Act
        // Assert
        assertThat(palindromeManager.evaluatePalindromeInRange(1, 10)).hasSize(5);
    }

    @Test
    public void evaluateNumberPalindromeRangeOneToOneMillionHas19Items() {
        // Arrange
        // Act
        // Assert
        assertThat(palindromeManager.evaluatePalindromeInRange(1, 1000000)).hasSize(19);
    }

    @Test
    public void evaluateInRangeXYNegativeParamsReturnsZeroElements() {
        // Arrange
        List<PalindromeInfo> palindromeEmptyXYNegativeList;

        // Act
        palindromeEmptyXYNegativeList = palindromeManager.evaluatePalindromeInRange(-1, -1);

        // Assert
        assertThat(palindromeEmptyXYNegativeList).hasSize(0);
    }

    @Test
    public void evaluateInRangeYGreaterThanXReturnsZeroElements() {
        // Arrange
        List<PalindromeInfo> palindromeEmptyYGreaterThantXList;

        // Act
        palindromeEmptyYGreaterThantXList = palindromeManager.evaluatePalindromeInRange(2, 1);

        // Assert
        assertThat(palindromeEmptyYGreaterThantXList).hasSize(0);
    }

    @Test
    public void evaluateInRangeYOutsideUpperBoundaryReturnsZeroElements(){
        // Arrange
        List<PalindromeInfo> palindromeEmtpyYOutsideUpperBoundaryList;

        // Act
        palindromeEmtpyYOutsideUpperBoundaryList = palindromeManager.evaluatePalindromeInRange(1, 1000001);

        // Assert
        assertThat(palindromeEmtpyYOutsideUpperBoundaryList).hasSize(0);
    }

    @Test
    public void evaluateNumberPalindromeInRange1To10Has5ItemsWithLambda() {
        // Arrange
        // Act
        // Assert
        assertThat(palindromeManager.evaluatePalindromeInRangeWithLambda(1, 10)).hasSize(5);
    }

    @Test
    public void evaluateNumberPalindromeRangeOneToOneMillionHas19ItemsWithLambda() {
        // Arrange
        // Act
        // Assert
        assertThat(palindromeManager.evaluatePalindromeInRangeWithLambda(1, 1000000)).hasSize(19);
    }
}
