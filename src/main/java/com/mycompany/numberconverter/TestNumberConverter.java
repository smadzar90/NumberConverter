/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.numberconverter;

import java.util.Scanner;

/**
 *
 * @author stipanmadzar
 */
public class TestNumberConverter {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        NumberConverter converter = new NumberConverter();
        Scanner scan = new Scanner(System.in);
        System.out.println("\nNUMBER CONVERSION PROGRAM");
        System.out.println("\nOptions:");
        System.out.println("1. 16-bit binary number to unsigned decimal integer");
        System.out.println("2. Unsigned decimal integer to 16-bit binary number");
        System.out.println("3. 16-bit binary number to unsigned hexadecimal integer");
        System.out.println("4. Unsigned hexadecimal integer to 16-bit binary number");
        System.out.println("5. Signed decimal number to 16-bit binary 2’s complement signed integer number");
        System.out.println("6. 16-bit binary 2’s complement signed integer number to signed decimal");
        System.out.print("\nSelect an option(1-6): ");
        String option = scan.nextLine();
        String number;
        
        switch (option) {
            case "1":
                System.out.print("\nEnter an 16-bit binary number(Ex: 0000000000001101): ");
                number = scan.nextLine();
                if(converter.is16BitBinary(number)) {
                    converter.binaryToDecimalConversion(number);
                }
                else {
                    System.out.println("\nError! 16-bit binary number not entered.\n");
                }   break;
            case "2":
                System.out.print("\nEnter an unsigned decimal integer(Ex: 124): ");
                number = scan.nextLine();
                if(converter.isPositiveDecimal(number)) {
                    long longVal = Long.parseLong(number);
                    converter.decimalToBinaryConversion(longVal);
                }
                else {
                    System.out.println("\nError! Unsigned decimal integer not entered.\n");
                }   break;
            case "3":
                System.out.print("\nEnter an 16-bit binary number(Ex: 0000000000001101): ");
                number = scan.nextLine();
                if(converter.is16BitBinary(number)) {
                    converter.binaryToHexaDecimalConversion(number);
                }
                else {
                    System.out.println("\nError! 16-bit binary number not entered.\n");
                }   break;
            case "4":
                System.out.print("\nEnter an unsigned hexadecimal integer(Ex: F18D): ");
                number = scan.nextLine();
                if(converter.isPositiveHexaDecimal(number)) {
                    converter.hexaDecimalToBinaryConversion(number);
                }
                else {
                    System.out.println("\nError! Unsigned hexadecimal integer not entered.\n");
                }   break;
            case "5":
                System.out.print("\nEnter an signed decimal integer(Ex: -15): ");
                number = scan.nextLine();
                int len = number.length();
                if(len == 0) {
                    System.out.println("\nError! Signed decimal integer not entered.\n");
                }
                else if(number.charAt(0) == '-') {
                    String absStr = number.substring(1);
                    if(converter.isPositiveDecimal(absStr)) {
                        converter.signedDecimalToBinary2compConversion(number);
                    }
                    else {
                        System.out.println("\nError! Signed decimal integer not entered.\n");
                    }
                }
                else {
                    if(converter.isPositiveDecimal(number)) {
                        converter.signedDecimalToBinary2compConversion(number);
                    }
                    else {
                        System.out.println("\nError! Signed decimal integer not entered.\n");
                    }
                }   break;  
            case "6":
                System.out.print("\nEnter an 16-bit binary number(Ex: 0000000000001101): ");
                number = scan.nextLine();
                if(converter.is16BitBinary(number)) {
                    converter.binary2compToSignedDecimalConversion(number);
                }
                else {
                    System.out.println("\nError! 16-bit binary number not entered.\n");
                }   break; 
            default:     
                System.out.println("\nError! Option not entered.\n");
                break;
        }
        
    }
    
}
