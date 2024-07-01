package com.zipcodewilmington.scientificcalculator;

import java.util.Random;
import java.util.Scanner;

//create java class named console for all calculations
public class Console {
    // create new scanner instance of the built in scanner class
    private static Scanner scanner = new Scanner(System.in);
    //declare memory to store a value, initialize as 0
    //us a double floating-point number for memory (numbers with decimal points)
    private static double memory = 0.0; // Memory variable to store result
    public static Random randomGenerator = new Random(System.currentTimeMillis());
    static int counter=0;
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
        String abc= scanner.nextLine();
        return abc;
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
    // method to store value into memory
    public static void storeInMemory(double result) {
        // check if memory IS NOT a non-number
        if (!Double.isNaN(result)) {
            memory = result;
            println("Your result is stored to memory.");
        }
    }
    // method to recall memory value
    public static double recallMemory() {
        //println("Recalling result from memory: " + memory);
        return memory;
    }
    // method to
    public static void clearMemory() {
        memory = 0.0;
        println(memory + " Memory cleared.");
    }
    // takes num 1, an operator, and num 2 and returns result, after checking each case
    // the class name = performOperation
    public static double performOperation(double num1, char operator, double num2) {
        // declare + initialize display result to 0
        double result = 0.0;
        // declare + initialize
        //check if memory
        //define switch cases for operator
        switch (operator) {
            case '+':
                //result = add(num1,num2);
                result = Console.add(num1,num2); //addition
                break;
            case '-':
                result = num1 - num2; //subtraction
                break;
            case '*':
                result = num1 * num2;

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
    // Qian
    // trig functions
    public static double TrigFunction(){
        System.out.println("welcome to Trig Function: \n");
        System.out.println("Choose from the following option: \n1.Sine\n2.Cosine\n3.Tangent\n4.Inverse Sine\n5.Inverse Cosine\n6.Inverse Tangent");

        // consume newline char from buffer
        //scanner.nextLine();

        double result=0;
        int input=scanner.nextInt();

        switch (input){

            case 1:
                System.out.println("sin__");
                double sininput = scanner.nextDouble();
                result = Math.sin(sininput);
                break;
            case 2:
                System.out.println("cos__");
                double cosinput = scanner.nextDouble();
                result=Math.cos(cosinput);
                break;
            case 3:
                System.out.println("tan__");
                double taninput = scanner.nextDouble();
                result=Math.tan(taninput);
                break;
            case 4:
                System.out.println("inverseSin___'");
                double insin=scanner.nextDouble();
                result =Math.asin(insin);
                break;
            case 5:
                System.out.println("inverseCos___'");
                double incos=scanner.nextDouble();
                result = Math.acos(incos);
                break;
            case 6:
                System.out.println("inverseTan___");
                double intan = scanner.nextDouble();
                result = Math.atan(intan);
                break;
            default:
                System.out.println("invalid\nxxxxxxxxxxxxxxxxx");
                //error();
                break;

        }
        //
        storeInMemory(result);

        // consume newline char from buffer
        Console.print("'In Radians' ");
        scanner.nextLine();
        //System.out.println("result is "+result);
        return result;
    }
    //Jared
    public static double absoluteValue(double num){
        return Math.abs(num);
    }
    //Jared
    // declare method for advanced functions
    public static double AdvFunction(){
        System.out.println("Advanced Functions: \n");
        System.out.println("Choose from following options: \n 1. Squared \n 2. Square Root \n 3. Switch Sign \n 4. Variable Exponent \n 5. Factorial \n 6. Inverse");
        double result = 0;
        int input = scanner.nextInt();

        // consume newline char from buffer
        scanner.nextLine();

        switch (input){
            case 1:
                System.out.println("number to be squared....");
                double squareInp = scanner.nextDouble();
                result = squareInp * squareInp;
                break;
            case 2:
                System.out.println("find square root of.....");
                double sqrtInp = scanner.nextDouble();
                result = Math.sqrt(sqrtInp);
                break;
            case 3:
                System.out.println("switch the sign of.....");
                double sw = scanner.nextDouble();
                result= -(sw);
                break;
            case 4:
                System.out.println("Pick initial number.....");
                double num1 = scanner.nextDouble();
                System.out.println("Pick exponent number.....");
                double num2 = scanner.nextDouble();
                result= Math.pow(num1, num2);
                break;
            case 5:
                double temp=1;
                Console.println("Factorial number is ___");
                double fac = scanner.nextDouble();
                for(int i=1;i<=fac;i++){
                    temp*=i;
                }
                result=temp;
                //Console.println("your result is "+result);
                break;
            case 6:
                Console.println("The number you want to inverse");
                int invnum = scanner.nextInt();
                //Console.println("1.0/"+invnum);
                result = 1.0 / invnum;
                break;
            default:
                System.out.println("invalid\nxxxxxxxxxxxxxxxxx");
                //error();
                break;
        }
        // consume newline char from buffer
        scanner.nextLine();
        storeInMemory(result);
        //System.out.println("The result is " + result);
        return result;
    }
    // Jared
    // declare method for switching
    public static String switchDisplay(String mode){
        int number = (int) recallMemory();
        String result = "";

        // Create a series of boolean values that represent whether the mode equals "b", "o", "h", or "d"
        // Ignoring case, so "B" and "b" are valid inputs
        boolean isBinary = mode.equalsIgnoreCase("b");
        boolean isOctal = mode.equalsIgnoreCase("o");
        boolean isHex = mode.equalsIgnoreCase("h");
        boolean isDecimal = mode.equalsIgnoreCase("d");

        if (isBinary) {
            result = Integer.toBinaryString(number);
            Console.print("As Binary.." + result + '\n');
        }
        else if (isOctal) {
            result = Integer.toOctalString(number);//number.toString(100, 8);
            Console.print("As Octal.." + result + '\n');
        }
        else if (isHex) {
            result = Integer.toHexString(number).toUpperCase();
            Console.print("As Hexadecimal.." + result + '\n');
        }
        else if (isDecimal) {
            result = Integer.toString(number);
            Console.print("As Decimal.." + result + '\n');
        }
        else {
            result = "Invalid";
        }

        return result;
    }
    //Jared
    // switch units from radians to degrees
    public static double switchUnitsMode(String mode){
        double scientificMemory = recallMemory();

        // Creating a series of boolean values that represent whether the input equals "r" or "d"
        boolean isRadians = mode.equalsIgnoreCase("r");
        boolean isDegrees = mode.equalsIgnoreCase("d");

        if (isRadians) {
            scientificMemory = Math.toRadians((scientificMemory));
            Console.print("Radians is " + scientificMemory);
        } else if (isDegrees) {
            scientificMemory = Math.toDegrees(scientificMemory);
            Console.print("Degree is " + scientificMemory);
        }
        else {
            Console.println("Invalid");
            scientificMemory = 0;
        }

        return scientificMemory;
    }
    //Jared
    // custom function random
    public static double random() {
        double randomNumber = Math.random()*10000;
        storeInMemory(Math.round(randomNumber));
        return Math.round(randomNumber);
    }
    //Qian
    // declare method for Log functions
    public static double Logarithmic(){
        System.out.println("Welcome to Logarithmic Functions:\n");
        System.out.println("Choose from following options: \n1.Log(x) base10 \n2.Log(x) inverseLog base10 \n3.ln(x) \n4.ln(x) inverseLog" );
        double result=0;
        int input=scanner.nextInt();

        // consume newline char from buffer
        scanner.nextLine();

        switch (input){
            case 1:
                System.out.println("Log:_");
                double loginput=scanner.nextDouble();
                result = Math.log10(loginput);
                break;
            case 2:
                System.out.println("Inverse Log_");
                double inverselog=scanner.nextDouble();
                result = Math.pow(10, inverselog);
                break;
            case 3:
                System.out.println("screen: ln_ ");
                double lninput = scanner.nextDouble();
                result= Math.log(lninput);
                break;
            case 4:
                System.out.println("screen : inverse ln_");
                double inverseln = scanner.nextDouble();
                result=Math.exp(inverseln);
                break;
            default:
                System.out.println("invalid\nxxxxxxxxxxxxxxxxx");
                //error();
                break;
        }
        // consume newline char from buffer
        scanner.nextLine();
        storeInMemory(result);
        //System.out.println("result is "+result);
        return result;

    }
    //rotate through options
    public static void rota(){

        int counter = 0;
        while (true) {
            int input = scanner.nextInt();

            if (input == 1) {//1. switch
                counter++;
                switch (counter%4){
                    case 1:
                        switchDisplay("b");
                        break;
                    case 2:
                        switchDisplay("o");
                        break;
                    case 3:
                        switchDisplay("d");
                        break;
                    case 0:
                        switchDisplay("h");
                        break;
                }
            }

            if (input == 9) {
                break;
            }
        }
        MainApplication.getMainMenuChoice();

    }

    //Methods to Test
    //Basic Test
    public static double add(double n1, double n2){
        return n1 + n2;
    }

    public static double square(double num){
        return num*num;
    }

    public  static double log(double input){
        return Math.log10(input);
    }

    public static double sin(double input){
        return  Math.sin(input);
    }

}