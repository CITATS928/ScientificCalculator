package com.zipcodewilmington.scientificcalculator;

import java.util.Scanner;

public class MainApplication {
    // calculator turns on
    public static void main(String[] args) {
        Console.println("Welcome to our calculator!");

        //Display 0 at start
        Console.println("\n 0");
        //Console.println("0");
        // Start loop, us a boolean while calculator is running
        while (true) {
            // calculator is active until false

            // Check if memory has a value other than zero
            double memoryValue = Console.recallMemory();
            if (memoryValue != 0.0) {
                double num1 = memoryValue;
                Console.println("Continue with current value in memory [ " + num1 + " ]");
            }

            // single character = 'the user choice'
            char choice = getMainMenuChoice();

            // user menu selection cases
            switch (choice) {
                case 'b':
                    double result;
                    // if memory != 0, then use memory as num1
                    double num1 = Console.getDoubleInput("Enter first number:");


                    //jared
                    //peter
                    char operator = Console.getStringInput("Enter operator (+,-,*,/):").charAt(0);;
                    double num2 = Console.getDoubleInput("Enter second number:");
                    // perform basic operation with operator
                    result = Console.performOperation(num1, operator, num2);
                    Console.println("Result: " +  result);
                    break;

                case 'a':
                    //
                    result = Console.AdvFunction();
                    Console.println("Result: " +  result);
                    break; // break or return?
                case 't':
                    result = Console.TrigFunction();
                    Console.println("Result: " +  result);
                    break; // break or return?
                case 'l':
                    //
                    result = Console.Logarithmic();
                    Console.println("Result: " + result);
                    break;
                case 'm': // Continue with stored value in memory
                    // set num1 to memory value
                    // Continue with stored value in memory
                    //operator = Console.getStringInput("Enter operator (+, -, *, /):").charAt(0);
                    //num2 = Console.getDoubleInput("Enter second number:");
                    result = Console.recallMemory();
                    Console.println("Starting with memory value: " +  result);
                    break;
                case 'c':
                    // Clear all - Start a new calculation
                    Console.clearMemory();
                    break;
                // Display switch
                case 's':
                    Scanner scanner = new Scanner(System.in);
                    Console.println("switch? binary/h-hexadecimal/o-octal/d-decimal\");");
                    String s = scanner.nextLine();
                    //result = Console.switchDisplay(s);
                    Console.println("Result: " + Console.switchDisplay(s));
                    break;
                case 'd':
                    // Degrees/Radians
                    Scanner scanner2 = new Scanner(System.in);
                    Console.println("Switch? r-radians/d-degrees\");");
                    String s1 = scanner2.nextLine();
                    //result = Console.switchDisplay(s);
                    Console.println("Result: " + Console.switchUnitsMode(s1));
                    break;
                case 'p':
                    Console.println("Enter 1 repeatedly to cycle through display.\nEnter 9 to exit cycle.");
                    Console.rota();
                    break;
                case 'q':
                    // Quit the calculator
                    Console.println("Final result in memory: " + Console.recallMemory());
                    Console.println("Calculator closed. Goodbye!");
                    return;
                case 'r':
                    result = Console.random();
                    Console.println("Here's a random value! :)   " +  result);
                    break; // break or return?
                case 'v':
                    double absolute = Console.recallMemory();
                    result = Console.absoluteValue(absolute);
                    Console.println("Absolute value of memory value is " +  result);
                    break; // break or return?

                default:
                    Console.println("Current result in memory : " + Console.recallMemory());
                    Console.println("Invalid choice. Please choose again.");


            }
        }
    }

    // menu // menu // menu // menu // menu // menu // menu // menu // menu
    public static char getMainMenuChoice() {
        Console.println("\nChoose (enter character)");
        Console.println(" b. Basic Math...");
        Console.println(" a. Advanced Functions..."); //Factorial in here
        Console.println(" t. Trig Functions..."); //Switch trig units mode (Degrees, Radians)
        Console.println(" l. Logarithmic Functions...");
        Console.println(" c. Clear All"); /////!!!!!!!
        Console.println(" s. Switch...");
        Console.println(" d. Degree/Radians");
        Console.println(" r. Custom Function1");
        Console.println(" v. Custom Function2");
        Console.println(" p. Cycle through Binary/Hex/Octal/Decimal");
        Console.println(" m. Memory = " + Console.recallMemory()); //
        Console.println(" q. Quit");

        // Choice from input, get string
        String choice = Console.getStringInput("\nEnter your choice (b/a/t/l/c/s/d/f/m/q):").toLowerCase();

        // if the length is 1, and matches a menu item, get 1st character entered by user
        if (choice.length() == 1 && (choice.equals("b") || choice.equals("a") || choice.equals("t") || choice.equals("l") || choice.equals("c") || choice.equals("s") || choice.equals("d") || choice.equals("r") || choice.equals("v") || choice.equals("m") || choice.equals("q") || choice.equals("p"))){
            return choice.charAt(0);
        } else {
            // if user enters something other than menu commands
            Console.println("Invalid selection - Please choose again.");
            // display menu again
            return getMainMenuChoice();
            //push test
        }
    }
}