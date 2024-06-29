package com.zipcodewilmington.scientificcalculator;

import java.util.Scanner;

<<<<<<< HEAD
/**
 * Created by leon on 2/9/18.
 */
public class  Console {
=======
public class Console {
    //declare scanner
    private static Scanner scanner = new Scanner(System.in);
    //declare memory as 0 first value
    private static double memory = 0.0; // Memory variable to store result
>>>>>>> 4c5e425256868134d0972936d642907080cd48b9

    //declare print (print output)
    public static void print(String output, Object... args) {
        System.out.printf(output, args);
    }

    //
    public static void println(String output, Object... args) {
        print(output + "\n", args);
    }

    public static String getStringInput(String prompt) {
        println(prompt);
        return scanner.nextLine();
    }

    public static int getIntegerInput(String prompt) {
        while (true) {
            try {
                println(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                println("Invalid input! Please enter an integer.");
            }
        }
    }

    public static double getDoubleInput(String prompt) {
        while (true) {
            try {
                println(prompt);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                println("Invalid input! Please enter a number.");
            }
        }
    }

    public static void storeInMemory(double result) {
        if (!Double.isNaN(result)) {
            memory = result;
            println("Result stored in memory.");
        }
    }

    public static double recallMemory() {
        println("Recalling result from memory: " + memory);
        return memory;
    }
    // de
    public static void clearMemory() {
        memory = 0.0;
        println("Memory cleared.");
    }
    // declare operator variables in a constructor
    // takes num 1, an operator, and num 2 and returns result, after checking each case
    // the class name = performOperation
    public static double performOperation(double num1, char operator, double num2) {
        //initialize display to 0
        double result = 0.0;

        //define switch cases for operator
        switch (operator) {
            case '+':
                result = add(num1,num2);
//                result = num1 + num2; //addition
                break;
            case '-':
                result = num1 - num2; //subtraction
                break;
            case '*':
                if (num1 == 0 || num2 == 0) { //return zero
                    println("Multiplied by zero");
                    result = 0; // Indicate error
                } else {
                    result = num1 * num2;
                }
                break;
            case '/':
                if (num2 != 0)
                    result = num1 / num2;
                else {
                    // print message if num 2 is 0, can't divide by 0
                    println("Error: Division by zero");
                    result = Double.NaN; // Indicate error
                }
                break;
            default:
                // print message if = - * / not entered in input/scanner
                println("Invalid operator: " + operator);
                result = Double.NaN; // Indicate error
                break;
        }

        //call store in memory method to store result
        storeInMemory(result); // Store result in memory

        return result;
    }
}