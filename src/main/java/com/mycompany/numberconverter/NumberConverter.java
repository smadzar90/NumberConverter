/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.numberconverter;

/**
 *
 * @author stipanmadzar
 */
public class NumberConverter {

    protected boolean is16BitBinary(String number) {
        
        for(int i = 0; i < number.length(); ++i) {
            if(!(number.charAt(i) == '0' || number.charAt(i) == '1')) {
                return false;
            }
        }
        if(number.length() != 16) {
            return false;
        }
        return true;
    }
    
    protected boolean isPositiveDecimal(String number) {
        
        if(number.length() == 0) {
            return false;
        }
        if(number.length() > 1 && number.charAt(0) == '0' || number.charAt(0) == '-') {
            return false;
        }
        try {
            long longVal = Long.parseLong(number);
        }
        catch(NumberFormatException e) {
            return false;
        } 
        return true;    
    }
    
    
    protected boolean isPositiveHexaDecimal(String number) {
        
        if(number.length() == 0) {
            return false;
        }
        if(number.length() > 1 && number.charAt(0) == '0' || number.charAt(0) == '-') {
            return false;
        }
        for(int i = 0; i < number.length(); ++i) {
            char ch = number.charAt(i);
            
            if ((ch < '0' || ch > '9')
            && (ch < 'A' || ch > 'F')) {
                return false;
            }
        }
        return true;  
    }
    
    protected int checkHexaLetter(char ch) {
        switch(ch) {
                case 'A':
                    return 10;
                case 'B':
                    return 11;
                case 'C': 
                    return 12;
                case 'D': 
                    return 13;
                case 'E':
                    return 14;
                case 'F':
                    return 15; 
                default:
                    int num = Character.getNumericValue(ch);
                    return num;
            }   
    }
    
    protected void binaryToDecimalConversion(String number) {
      int count = 1;
      int lastChar = number.length() - 1;
      int result = 0;
      
      for(int i = lastChar; i >= 0; i--) {
          if(number.charAt(i) == '1') {
              result += count;
          }
          count *= 2;
      }
      System.out.println("---------------------------------------------------");
      System.out.println("\n16-bit binary number --> " + number);
      System.out.println("\nEquals: ");
      System.out.println("\nUnsigned decimal integer --> " + result);
    }
    
    protected void decimalToBinaryConversion(Long number) {
        if(number > 65535) {
            System.out.println("\n**ERROR: Input requires more than 16 bits!");
        }
        else {
        String result = "";
        long num = number;
        
        while(number != 0) {
            long remainder = number % 2;
            number /= 2;
            result = remainder + result;
            if(result.length() == 16) {
                break;
            }
        }
        while(result.length() < 16) {
            result = "0" + result;
        }
        
        System.out.println("---------------------------------------------------");
        System.out.println("\nUnsigned decimal integer --> " + num); 
        System.out.println("\nEquals: ");
        System.out.println("\n16-bit binary number --> " + result);
        }
    }
    
    protected void binaryToHexaDecimalConversion(String number) {
        
        int position = 0;
        int count = 1;
        int result = 0;
        boolean cc = false;
        String res = "";
        
        while(true) {
            
            if(position == 16) {
                break;
            }
            String sub = number.substring(position, position + 4);
            for(int i = 3; i >= 0; i--) {
                if(sub.charAt(i) == '1') {
                    result += count;
                }
                count *= 2;
            }
            
            switch(result) {
                case 10:
                    res += "A";
                    cc = true;
                    break;
                case 11:
                    res += "B";
                    cc = true;
                    break;
                case 12: 
                    res += "C";
                    cc = true;
                    break;
                case 13: 
                    res += "D";
                    cc = true;
                    break;
                case 14:
                    res += "E";
                    cc = true;
                    break;
                case 15:
                    res += "F";
                    cc = true;
                    break;  
                default:
                    if(result != 0) {
                        cc = true;
                    }
                    if(cc) {
                    String result2 = String.valueOf(result);
                    res += result2;
                    }
            }
            position += 4;
            count = 1;
            result = 0;
        }
        if(res.equals("")) {
            res = "0";
        }
        
        System.out.println("---------------------------------------------------");
        System.out.println("\n16-bit binary number --> " + number);
        System.out.println("\nEquals: ");
        System.out.println("\nUnsigned hexadecimal integer --> " + res);
    } 
    
    protected void hexaDecimalToBinaryConversion(String number) {
        String numS = number;
        if(number.length() > 4) {
            System.out.println("\n**ERROR: Input requires more than 16 bits!");
        }
        else {
            if(number.length() < 4) {
                int len = 4 - number.length();
                while(len > 0) {
                    number = "0" + number;
                    len--;
                }
            }
        String result = "";
        String sub = "";
        
        for(int i = 0; i < 4; ++i) {
            
            int num = checkHexaLetter(number.charAt(i));
            
            while(num > 0) {
                sub = (num % 2) + sub;
                num /= 2;
            }
            while(sub.length() < 4) {
            sub = "0" + sub;
            }
            result += sub;
            sub = "";   
        }
        
        System.out.println("---------------------------------------------------");
        System.out.println("\nUnsigned hexadecimal integer --> " + numS);
        System.out.println("\nEquals: ");
        System.out.println("\n16-bit binary number --> " + result); 
        }
    }
    
    protected void signedDecimalToBinary2compConversion(String number) {
        
        long longN = Long.parseLong(number);
        
        if(number.charAt(0) == '-') {
            if(longN > -32769) {
            String sub = number.substring(1);
            String result = "";
            long num = Long.parseLong(sub);
            
            while(num > 0) {
                long reminder = num % 2;
                num /= 2;
                result = reminder + result;
                if(result.length() == 16) {
                    break;
                }
            }
            while(result.length() < 16) {
                result = "0" + result;
            }
            StringBuilder sb = new StringBuilder(result);
            for(int i = 0; i < 16; ++i) {
                if(sb.charAt(i) == '0') {
                    sb.setCharAt(i, '1');
                }
                else {
                    sb.setCharAt(i, '0');
                }
            }
            for(int i = sb.length() - 1; i >= 0; i--) {
                if(sb.charAt(i) == '0') {
                    sb.setCharAt(i, '1');
                    break;
                }
                else {
                    sb.setCharAt(i, '0');
                }
            }
            System.out.println("---------------------------------------------------");
            System.out.println("\nSigned decimal integer --> " + number); 
            System.out.println("\nEquals: ");
            System.out.println("\n16-bit binary 2’s complement signed integer number --> " + sb); 
            }
            else {
                System.out.println("\n**ERROR: Input requires more than 16 bits!");
            }
        }
        else {
            if(longN < 32768) {
            String result = "";
            long num = Long.parseLong(number);
            
            while(num > 0) {
                long reminder = num % 2;
                num /= 2;
                result = reminder + result;
                if(result.length() == 16) {
                    break;
                }
            }
            while(result.length() < 16) {
                result = "0" + result;
            }
            System.out.println("---------------------------------------------------");
            System.out.println("\nSigned decimal integer --> " + number); 
            System.out.println("\nEquals: ");
            System.out.println("\n16-bit binary 2’s complement signed integer number --> " + result);  
            }
            else {
                System.out.println("\n**ERROR: Input requires more than 16 bits!");
            }
        }
    }
             
    protected void binary2compToSignedDecimalConversion(String number) {
       
        if(number.charAt(0) == '0') {
            int count = 1;
            int lastChar = number.length() - 1;
            int result = 0;
            
            for(int i = lastChar; i >= 0; i--) {
                if(number.charAt(i) == '1') {
                   result += count;
                }
                count *= 2;
            }
            System.out.println("---------------------------------------------------");
            System.out.println("\n16-bit binary number --> " + number);
            System.out.println("\nEquals: ");
            System.out.println("\nUnsigned decimal integer --> " + result);
        }
        else {
            StringBuilder sb = new StringBuilder(number);
            for(int i = 0; i < 16; ++i) {
                if(sb.charAt(i) == '0') {
                    sb.setCharAt(i, '1');
                }
                else {
                    sb.setCharAt(i, '0');
                }
            }
            for(int i = sb.length() - 1; i >= 0; i--) {
                if(sb.charAt(i) == '0') {
                    sb.setCharAt(i, '1');
                    break;
                }
                else {
                    sb.setCharAt(i, '0');
                }
            }
            int count = 1;
            int lastChar = sb.length() - 1;
            int result = 0;
            
            for(int i = lastChar; i >= 0; i--) {
                if(sb.charAt(i) == '1') {
                   result += count;
                }
                count *= 2;
            }
            System.out.println("---------------------------------------------------");
            System.out.println("\n16-bit binary number --> " + number);
            System.out.println("\nEquals: ");
            System.out.println("\nUnsigned decimal integer --> -" + result);
 
        }
    }
           
}
