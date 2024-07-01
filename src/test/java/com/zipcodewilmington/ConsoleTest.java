package com.zipcodewilmington;

import com.zipcodewilmington.Console;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ConsoleTest {
    @Before
    public void setup() {
        Console.clearMemory();
    }
     @Test
    public void testStoreMemory() {
        double memoryTest = 3.2;
        Console.storeInMemory(memoryTest);

        double storedMemory = Console.recallMemory();
        Assert.assertEquals(memoryTest, storedMemory, 0.001);
    }

    @Test
    public void testStoreMemoryInvalid() {
        double memoryTest = Double.NaN;
        Console.storeInMemory(memoryTest);

        double memory = Console.recallMemory();
        Assert.assertEquals(memory, 0.0, 0.0001);
    }

    @Test
    public void testClearMemory() {
        double memoryTest = 3.1;
        Console.storeInMemory(memoryTest);

        Console.clearMemory();
        Assert.assertEquals(0.0, Console.recallMemory(), 0.001);
    }
    @Test
    public void testOperatorsPlus(){
        double addition = Console.performOperation(1, '+', 1);
        Assert.assertEquals(2, addition, .0001);
    }

    @Test
    public void testOperatorsSub(){
        double subtraction = Console.performOperation(1,'-',1);
        Assert.assertEquals(0, subtraction, .0001);
    }

    @Test
    public void testOperatorsMult(){
        double mult = Console.performOperation(1,'*',1);
        Assert.assertEquals(1,mult,.0001);
    }

    @Test
    public void testOperatorsDiv(){
        double div = Console.performOperation(4,'/',2);
        Assert.assertEquals(2, div, .0001);
    }

    @Test
    public void testOperatorsDivByZero(){
        double div = Console.performOperation(1,'/', 0);
        Assert.assertEquals(Double.NaN, div, .0001);
    }
     @Test
    public void testOperatorsInvalid(){
        double op = Console.performOperation(1,'l',1);
        Assert.assertEquals(Double.NaN, op, .0001);
    }

    @Test
    public void log(){
        assertEquals(0.301, Console.log(2),0.1);
    }


    @Test
    public void sin(){
        assertEquals(-0.9589, Console.sin(5),0.0001);
    }

    @Test
    public void square(){
        assertEquals(4,Console.square(2),0.1);
    }
    @Test
    public void absoluteNegative() {
        double absolute = -1.0;
        double result = Console.absoluteValue(absolute);
        Assert.assertEquals(1.0, result, 0.0001);
    }

    @Test
    public void absolutePositive() {
        double absolute = 1.0;
        double result = Console.absoluteValue(absolute);
        Assert.assertEquals(1.0, result, 0.0001);
    }
    @Test
    public void switchModeBinary() {
        int binValue = 20;
        Console.storeInMemory(binValue);
        String result = Console.switchDisplay("b");
        Assert.assertEquals("10100", result);
    }

    @Test
    public void switchModeOctal() {
        int octalValue = 20;
        Console.storeInMemory(octalValue);
        String result = Console.switchDisplay("o");
        Assert.assertEquals("24", result);
    }
    @Test
    public void switchModeDecimal() {
        int decimalValue = 20;
        Console.storeInMemory(decimalValue);
        String result = Console.switchDisplay("d");
        Assert.assertEquals("20", result);
    }

    @Test
    public void switchModeHex() {
        int hexValue = 20;
        Console.storeInMemory(hexValue);
        String result = Console.switchDisplay("h");
        Assert.assertEquals("14", result);
    }
    @Test
    public void switchModeInvalid() {
        String result = Console.switchDisplay("z");
        String invalidResponse = "Invalid";
        Assert.assertEquals(invalidResponse, result);
    }
    @Test
    public void switchUnitsRadians() {
        double radiansAmount = 90.0;
        double result = Math.toRadians(radiansAmount);
        Console.storeInMemory(radiansAmount);
        double computedResult = Console.switchUnitsMode("r");
        Assert.assertEquals(result, computedResult, 0.0001);
    }
    @Test
    public void switchUnitsDegrees() {
        double degreesAmount = 25.7;
        double result = Math.toDegrees(degreesAmount);
        Console.storeInMemory(degreesAmount);
        double computedResult = Console.switchUnitsMode("d");
        Assert.assertEquals(result, computedResult, 0.0001);
    }

    @Test
    public void switchUnitsInvalid() {
        double computedValue = Console.switchUnitsMode("z");
        double invalidMemoryValue = 0.0;
        Assert.assertEquals(invalidMemoryValue, computedValue, 0.0001);
    }


}

