/*----------------------------------------------------------------------------*/
/* Source File:   HOMECONTROLLER.JAVA                                         */
/* Description:   Main page controller                                        */
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Main page controller
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Apr.25/2017
 * @since 1.8 (JDK), Apr.25/2017
 */
@Controller
@RequestMapping("/home")
@SuppressWarnings("unused")
public class HomeController {
    /**
     * Logger factory.
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Goes to the landing page of application.
     *
     * @return Home page view.
     */
    @RequestMapping("")
    public String index(Model model) {
        if (logger.isDebugEnabled()) {
            logger.debug("index started");
        }
        return "home/index";
    }
}
