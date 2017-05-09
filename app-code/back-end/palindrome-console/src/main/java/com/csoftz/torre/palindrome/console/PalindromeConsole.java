/*----------------------------------------------------------------------------*/
/* Source File:   PALINDROMECONSOLE.JAVA                                      */
/* Description:   A command line program to evaluate palindrome numbers       */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Apr.26/2017                                                 */
/* Last Modified: Apr.26/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Apr.26/2017 COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.torre.palindrome.console;

import com.csoftz.torre.palindrome.lib.domain.PalindromeInfo;
import com.csoftz.torre.palindrome.lib.domain.PalindromeValueContainer;
import com.csoftz.torre.palindrome.lib.utils.PalindromeManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/**
 * A command line program to evaluate palindrome numbers
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Apr.26/2017
 * @since 1.8 (JDK), Apr.26/2017
 */
@SpringBootApplication
public class PalindromeConsole implements CommandLineRunner {

    /**
     * Evaluates if there are palindrome numbers in range x y.
     * @param x start of range to evaluate.
     * @param y end of range to evaluate.
     */
    public  void processInRange(Integer x, Integer y) {
        PalindromeManager palindromeManager = new PalindromeManager();

        PalindromeValueContainer palindromeValueContainer = new PalindromeValueContainer();
        palindromeValueContainer.setX(x);
        palindromeValueContainer.setY(y);

        List<PalindromeInfo> infoList = palindromeManager.evaluatePalindromeInRange(x, y);
        palindromeValueContainer.setPalindromes(infoList);
        palindromeValueContainer.setNumOfPalindromes(infoList.size());

        Integer complexityTimes = y - x + 1;
        palindromeValueContainer.setComplexity("O(n)=O(y-x) = O(" + complexityTimes + ")");

        System.out.println("Parameter x used: " + palindromeValueContainer.getX());
        System.out.println("Parameter y used: " + palindromeValueContainer.getY());
        System.out.println("Number of Palindromes found: " + palindromeValueContainer.getNumOfPalindromes());
        System.out.println("Complexity: " + palindromeValueContainer.getComplexity());
        System.out.println("List of palindrome numbers found, follows:");

        infoList.forEach(info -> System.out.println(info.getNumber() + " | " + info.getNumberAsBinary()));
    }

    /**
     * Command line to determine a range of numbers for its palindrome nature, in this context
     * a palindrome of number is considere as such if both the number and its binary
     * representation is a palindrome. Example, 585 is palindrome and its binary representation
     * is 1001001001 is a palindrome.
     *
     * @param args Command line arguments
     */
    @Override
    public void run(String... args) throws Exception {
        if (args.length == 0){
            System.out.println();
            System.out.println("Usage: java -jar csoftz-torre-palindrome-console-1.0.0-RELEASE.jar [default]|[start end]");
            System.out.println("Where [default] uses the range from 1 to 1000000.");
            System.out.println("      [start] establishes an user defined range start.");
            System.out.println("      [end] establishes an user defined range end.");
            System.out.println();
            System.out.println("Examples");
            System.out.println("--------");
            System.out.println("java -jar csoftz-torre-palindrome-console-1.0.0-RELEASE.jar default which gives all palindromes from 1 to 1000000");
            System.out.println("java -jar csoftz-torre-palindrome-console-1.0.0-RELEASE.jar 2 100 which gives all palindromes from 2 to 100");
            System.out.println();
            return;
        }
        if (args.length == 1 && args[0].equals("default")){
            processInRange(1, 1000000);
        }
        if (args.length == 2) {
            boolean validInt = true;
            Integer x = 0;
            Integer y = 0;
            try {
                x = Integer.parseInt(args[0]);
                y = Integer.parseInt(args[1]);
            } catch (Exception e){
                validInt = false;
            }
            if (!validInt) {
                System.out.println("ERROR: Some of the supplied parameters for [start]/[end] is not a valid integer value.");
                System.out.println("App terminates.");
                System.out.println();
                return;
            }

            // Now let's validate that parameters are in range.
            boolean validXInRange = (x >= 1 && x <= 1000000);
            boolean validYInRange = (y >= 1 && y <= 1000000);
            if (!validXInRange || !validYInRange) {
                System.out.println("ERROR: One of the parameters supplied is not in the range (1..1000000)");
                System.out.println(("App terminates."));
                System.out.println();
                return;
            }
            if (x > y) {
                System.out.println("ERROR: The x value is greater than y value. It is not allowed.");
                System.out.println("App terminates");
                System.out.println();
                return;
            }

            // Now all validation rules pass, process.
            processInRange(x,y);
        }
    }

    /** 
     * Application entry point.
     */
    public static void main(String[] args) {
		SpringApplication.run(PalindromeConsole.class, args);
	}
}
