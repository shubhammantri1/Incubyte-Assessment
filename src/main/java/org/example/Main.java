package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {

    Map<String, Integer> delimeters = new HashMap<>();

    public Main() {

        //Initialize the delimeters
        delimeters.put(";", 3);
        delimeters.put("", 0);
    }


    /**
     * Method will take a string of comma or new line separated numbers. It will add all the numbers
     * and return the sum of all the numbers.
     *
     * Added support for delimeters.
     *
     * @param numbers
     * @return
     */
    public int add(String numbers) throws  NumberFormatException, Exception {

        if(Objects.isNull(numbers) || numbers.isEmpty())
            return 0;

        int result = 0;

        try{
            String[] numberList = numbers.split("[,\\n]+");
            for(String number: numberList) {
                int num = 0;
                if(delimeters.containsKey(number)){
                    num = delimeters.get(number);
                }
                else{
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

        Main addNumbers = new Main();

        // Task 1
        System.out.println(addNumbers.add("")); // Output: 0
        System.out.println(addNumbers.add("1,5")); // Output: 6
        System.out.println(addNumbers.add("6")); // Output: 6

        // Task 2
        System.out.println(addNumbers.add("1,2,3")); // Output: 6
        System.out.println(addNumbers.add("-1,1,3,5")); // Output: 8
        System.out.println(addNumbers.add(",,0,8")); // Output: 8

        // Task 3
        System.out.println(addNumbers.add("1,2\n3")); // Output: 6
        System.out.println(addNumbers.add("1\n-2\n3")); // Output: 2
        System.out.println(addNumbers.add("\n1,2\n3")); // Output: 6

        // Task 4
        System.out.println(addNumbers.add(";,;,;")); // Output: 6
        System.out.println(addNumbers.add(";")); // Output: 3
        System.out.println(addNumbers.add(",,0,8")); // Output: 8


    }
}