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
                int num = 0;
                if(!number.isEmpty()){
                    num = Integer.parseInt(number);
                }
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

        // Task 1
        System.out.println(add("")); // Output: 0
        System.out.println(add("1,5")); // Output: 6
        System.out.println(add("6")); // Output: 6

        // Task 2
        System.out.println(add("1,2,3")); // Output: 6
        System.out.println(add("-1,1,3,5")); // Output: 8
        System.out.println(add(",,0,8")); // Output: 8
    }
}