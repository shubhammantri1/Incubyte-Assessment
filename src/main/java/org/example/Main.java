package org.example;

import java.util.Objects;

public class Main {

    /**
     * Method will take a string of comma separated numbers. It will add all the numbers
     * and return the sum of all the numbers.
     *
     * @param numbers
     * @return
     */
    public static int add(String numbers) throws  NumberFormatException, Exception {

        if(Objects.isNull(numbers) || numbers.isEmpty())
            return 0;

        int result = 0;

        try{
            String[] numberList = numbers.split(",");
            for(String number: numberList) {
                int num = Integer.parseInt(number);
                result = num + result;
            }
        }
        catch(NumberFormatException nfe) {
            System.out.println("Error: Invalid Input. Please ensure valid inputs " + nfe);
            throw nfe;
        }
        catch(Exception e) {
            System.out.println("Error occurred while processing the input: " + numbers);
            System.out.println("Error: " + e);
            throw e;
        }
        return result;

    }

    public static void main(String[] args) throws Exception {

        System.out.println(add(""));
        System.out.println(add("1,5"));
        System.out.println(add("6"));

    }
}