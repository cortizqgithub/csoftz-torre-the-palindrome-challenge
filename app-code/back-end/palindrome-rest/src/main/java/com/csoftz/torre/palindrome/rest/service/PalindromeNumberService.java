/*----------------------------------------------------------------------------*/
/* Source File:   PALINDROMENUMBERSERVICE.JAVA                                */
/* Description:   Implements a service to evaluate palindrome numbers         */
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
package com.csoftz.torre.palindrome.rest.service;

import com.csoftz.torre.palindrome.lib.domain.PalindromeInfo;
import com.csoftz.torre.palindrome.lib.utils.PalindromeManager;
import com.csoftz.torre.palindrome.rest.service.interfaces.IPalindromeNumberService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implements a service to evaluate palindrome numbers
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.2, Oct.22/2017
 * @since 1.8 (JDK), Apr.25/2017
 */
@Service
@SuppressWarnings("unused")
public class PalindromeNumberService implements IPalindromeNumberService {

    /* Helper to handle palindrome number tasks. */
    private PalindromeManager palindromeManager;

    /**
     * Default constructor.
     */
    public PalindromeNumberService() {
        palindromeManager = new PalindromeManager();
    }

    /**
     * @see com.csoftz.torre.palindrome.rest.service.interfaces.IPalindromeNumberService#evaluateInRange(Integer x, Integer y)
     */
    @Override
    public List<PalindromeInfo> evaluateInRange(Integer x, Integer y) {
        return palindromeManager.evaluatePalindromeInRange(x, y);
    }

    /**
     * @see com.csoftz.torre.palindrome.rest.service.interfaces.IPalindromeNumberService#evaluateInRangeWithLambda(Integer x, Integer y)
     */
    @Override
    public List<PalindromeInfo> evaluateInRangeWithLambda(Integer x, Integer y) {
        return palindromeManager.evaluatePalindromeInRangeWithLambda(x, y);
    }
}
