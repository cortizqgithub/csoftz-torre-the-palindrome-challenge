/*----------------------------------------------------------------------------*/
/* Source File:   IPALINDROMENUMBERSERVICE.JAVA                               */
/* Description:   Defines the interface service to evaluate palindrome numbers*/
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

package com.csoftz.torre.palindrome.rest.service.interfaces;

import com.csoftz.torre.palindrome.lib.domain.PalindromeInfo;

import java.util.List;

/**
 * Defines the interface service to evaluate palindrome numbers.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Apr.25/2017
 * @since 1.8 (JDK), Apr.25/2017
 */
public interface IPalindromeNumberService {
    /**
     * Retrieves a list of palindrome numbers in range x and y.
     * Given a range of numbers in (x..y) where x <= y and valid integer values.
     *
     * 1 <= x <= 1000000
     * 1 <= y <= 1000000
     *
     * @param x Range Start
     * @param y Range End
     * @return If x > y then an empty list is returned. If any parameter is
     * outside range then and empty list is returned as well.
     */
    List<PalindromeInfo> evaluateInRange(Integer x, Integer y);
}
