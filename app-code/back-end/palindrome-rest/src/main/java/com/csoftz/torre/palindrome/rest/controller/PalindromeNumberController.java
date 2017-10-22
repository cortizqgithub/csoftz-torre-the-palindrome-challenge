/*----------------------------------------------------------------------------*/
/* Source File:   PALINDROMENUMBERCONTROLLER.JAVA                             */
/* Description:   REST API to evaluate palindrome numbers                     */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Apr.25/2017                                                 */
/* Last Modified: Oct.22/2017                                                 */
/* Version:       1.3                                                         */
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
 * @version 1.3, Oct.22/2017
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
     *
     * @return An object representing the desired output information for JSON serialization. The named object is of
     * type PalindromeValueContainer.
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

        Integer complexityTimes = y - x + 1;
        palindromeValueContainer.setComplexity("O(n)=O(y-x) = O(" + complexityTimes + ")");
        return palindromeValueContainer;
    }

    /**
     * Retrieves all palindrome numbers between 1 and 1 million.
     * <p><b>NOTE:</b>Uses the lambda version to compute results.</p>
     *
     * @return An object representing the desired output information for JSON serialization. The named object is of
     * type PalindromeValueContainer.
     */
    @GetMapping("/range/lambda")
    public PalindromeValueContainer rangeLambda() {
        Integer x = 1;
        Integer y = 1000000;

        PalindromeValueContainer palindromeValueContainer = new PalindromeValueContainer();
        palindromeValueContainer.setX(x);
        palindromeValueContainer.setY(y);

        List<PalindromeInfo> infoList = palindromeNumberService.evaluateInRangeWithLambda(x, y);
        palindromeValueContainer.setPalindromes(infoList);
        palindromeValueContainer.setNumOfPalindromes(infoList.size());

        Integer complexityTimes = y - x + 1;
        palindromeValueContainer.setComplexity("O(n)=O(y-x) = O(" + complexityTimes + ")");
        return palindromeValueContainer;
    }

    /**
     * Retrieves all palindrome numbers from x to y. If x = y then it evaluates to one value.
     * Here x<=y and 1<=x<=1000000 and 1<=y<=1000000.
     *
     * @param start Gives the initial value to evaluate.
     * @param end   Gives the final value to evaluate.
     * @return An object representing the desired output information for JSON serialization. The named object is of
     * type PalindromeValueContainer.
     */
    @GetMapping("/range/{start}/{end}")
    public ResponseEntity<PalindromeValueContainer> range(@PathVariable String start, @PathVariable String end) {
        Integer x, y;
        boolean validInt;

        validInt = true;
        x = y = 0;
        try {
            x = Integer.parseInt(start);
            y = Integer.parseInt(end);
        } catch (Exception e) {
            validInt = false;
        }

        if (!validInt) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        PalindromeValueContainer palindromeValueContainer = new PalindromeValueContainer();
        palindromeValueContainer.setX(x);
        palindromeValueContainer.setY(y);

        List<PalindromeInfo> infoList = palindromeNumberService.evaluateInRange(x, y);
        palindromeValueContainer.setPalindromes(infoList);
        palindromeValueContainer.setNumOfPalindromes(infoList.size());

        Integer complexityTimes = 1;
        if (x <= y) {
            complexityTimes = y - x + 1;
        }
        palindromeValueContainer.setComplexity("O(n)=O(y-x) = O(" + complexityTimes + ")");
        return new ResponseEntity<>(palindromeValueContainer, HttpStatus.CREATED);
    }

    /**
     * Retrieves all palindrome numbers from x to y. If x = y then it evaluates to one value.
     * Here x<=y and 1<=x<=1000000 and 1<=y<=1000000.
     * <p>
     * <p><b>NOTE:</b>Uses the lambda version to compute results.</p>
     *
     * @param start Gives the initial value to evaluate.
     * @param end   Gives the final value to evaluate.
     * @return An object representing the desired output information for JSON serialization. The named object is of
     * type PalindromeValueContainer.
     */
    @GetMapping("/range/lambda/{start}/{end}")
    public ResponseEntity<PalindromeValueContainer> rangeLambda(@PathVariable String start, @PathVariable String end) {
        Integer x, y;
        boolean validInt;

        validInt = true;
        x = y = 0;
        try {
            x = Integer.parseInt(start);
            y = Integer.parseInt(end);
        } catch (Exception e) {
            validInt = false;
        }

        if (!validInt) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        PalindromeValueContainer palindromeValueContainer = new PalindromeValueContainer();
        palindromeValueContainer.setX(x);
        palindromeValueContainer.setY(y);

        List<PalindromeInfo> infoList = palindromeNumberService.evaluateInRange(x, y);
        palindromeValueContainer.setPalindromes(infoList);
        palindromeValueContainer.setNumOfPalindromes(infoList.size());

        Integer complexityTimes = 1;
        if (x <= y) {
            complexityTimes = y - x + 1;
        }
        palindromeValueContainer.setComplexity("O(n)=O(y-x) = O(" + complexityTimes + ")");
        return new ResponseEntity<>(palindromeValueContainer, HttpStatus.CREATED);
    }
}
