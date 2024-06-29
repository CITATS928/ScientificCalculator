package com.zipcodewilmington.scientificcalculator;

public class MainApplication {

    public static void main(String[] args) {
        Console.println("Welcome to my calculator!");
        Console.println("0");

        //Hi Qian
        // Start loop, us a boolean
        while (true) {
            // calculator is active
            // declare 'choice' as
            char choice = getMainMenuChoice();

            switch (choice) {
                case 'c':
                    // Continue with stored value in memory
                    double num1 = Console.recallMemory();
                    // Continue with stored value in memory
                    char operator = Console.getStringInput("Enter operator (+, -, *, /):").charAt(0);
                    double num2 = Console.getDoubleInput("Enter second number:");
                    double result = Console.performOperation(num1, operator, num2);
                    Console.println("Result: " + result);
                    break;
                case 'y':
                    // Start a new calculation
                    num1 = Console.getDoubleInput("Enter first number:");
                    operator = Console.getStringInput("Enter operator (+, -, *, /):").charAt(0);
                    num2 = Console.getDoubleInput("Enter second number:");
                    result = Console.performOperation(num1, operator, num2);
                    Console.println("Result: " + result);
                    break;
                case 'q':
                    // Quit the calculator
                    Console.println("Final result in memory: " + Console.recallMemory());
                    Console.println("Calculator closed. Goodbye!");
                    return;
                default:
                    Console.println("Invalid choice. Please choose again.");
            }
        }
    }

    private static char getMainMenuChoice() {
        Console.println("\nMenu:");
        Console.println("c. Continue with stored value in memory");
        Console.println("y. Start a new calculation");
        Console.println("q. Quit");
        //Console.println("s. Scientific calculator")

        String choice = Console.getStringInput("Enter your choice (c/y/q):").toLowerCase();

        if (choice.length() == 1 && (choice.equals("c") || choice.equals("y") || choice.equals("q"))) {
            return choice.charAt(0);
        } else {
            Console.println("Invalid choice. Please choose again.");
            return getMainMenuChoice();
        }
    }
}