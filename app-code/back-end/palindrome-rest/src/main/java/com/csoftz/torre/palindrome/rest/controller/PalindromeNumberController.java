/*----------------------------------------------------------------------------*/
/* Source File:   PALINDROMENUMBERCONTROLLER.JAVA                             */
/* Description:   REST API to evaluate palindrome numbers                     */
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
package com.csoftz.torre.palindrome.rest.controller;

import com.csoftz.torre.palindrome.lib.domain.PalindromeInfo;
import com.csoftz.torre.palindrome.lib.domain.PalindromeValueContainer;
import com.csoftz.torre.palindrome.rest.service.interfaces.IPalindromeNumberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST API to evaluate palindrome numbers.
 * Given a range of numbers in (x..y) where x <= y and valid integer values.
 * <p>
 * 1 <= x <= 1000000
 * 1 <= y <= 1000000
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Apr.25/2017
 * @since 1.8 (JDK), Apr.25/2017
 */
@RestController
@RequestMapping("/api/v1/palindrome/numbers")
@SuppressWarnings("unused")
public class PalindromeNumberController {

    /* Gets inyected by IoC. */
    private IPalindromeNumberService palindromeNumberService;

    /**
     * Constructor with parameter
     *
     * @param palindromeNumberService Service for palindrome numbers tasks.
     */
    public PalindromeNumberController(IPalindromeNumberService palindromeNumberService) {
        this.palindromeNumberService = palindromeNumberService;
    }

    /**
     * Retrieves all palindrome numbers between 1 and 1 million.
     * @return A JSON object with result.
     */
    @GetMapping("/range")
    public PalindromeValueContainer range() {
        Integer x = 1;
        Integer y = 1000000;

        PalindromeValueContainer palindromeValueContainer = new PalindromeValueContainer();
        palindromeValueContainer.setX(x);
        palindromeValueContainer.setY(y);

        List<PalindromeInfo> infoList = palindromeNumberService.evaluateInRange(x, y);
        palindromeValueContainer.setPalindromes(infoList);
        palindromeValueContainer.setNumOfPalindromes(infoList.size());
        return palindromeValueContainer;
    }

    @GetMapping("/range/{start}/{end}")
    public PalindromeValueContainer range(@PathVariable String start, @PathVariable String end) {
        Integer x = Integer.parseInt(start);
        Integer y = Integer.parseInt(end);

        PalindromeValueContainer palindromeValueContainer = new PalindromeValueContainer();
        palindromeValueContainer.setX(x);
        palindromeValueContainer.setY(y);

        List<PalindromeInfo> infoList = palindromeNumberService.evaluateInRange(x, y);
        palindromeValueContainer.setPalindromes(infoList);
        palindromeValueContainer.setNumOfPalindromes(infoList.size());
        return palindromeValueContainer;
    }
}
