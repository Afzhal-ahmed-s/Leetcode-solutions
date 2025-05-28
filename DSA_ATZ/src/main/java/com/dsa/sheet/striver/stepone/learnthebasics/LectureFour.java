///Learnings:
// Convert int to string
// Convert string to string element array
// Convert String[] to int[] using stream API also
// using conventional procedure
// Convert array of String to ArrayList using stream API

// Algorithm to reverse a number
// Maximum and minimum range value of a data type eg: int?
// Math class functions [Math.abs()]

// Find maximum and minimum of two numbers-
// Using ternary operator and Math class
// Eucilidian [mathematical] formula for GCD and LCM
// GCD mathematical formula
// Check if two strings are not equal, operation
// T.C ? -> !(s1.equals(s2)), O(smaller string length)
// Cut a subtring, T.C ? -> s1.substring(s2), O(N)

// Find length of an integer number
// Math.pow(number, pow)

// Math.sqrt()
// How to fill an entire array in a single line?
// -> Arrays.fill(arr, 2)
// Divisors [mathematical] logic
// Q.6 Interesting time complexity

// seiveOfEratosthenes T.c ? -> O( n log( log(N) ) )
/*
What did I do wrong here?

1. Rushed, did not read question well.
2. Did not use notebook.
 */


package com.dsa.sheet.striver.stepone.learnthebasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class LectureFour {

        // 1
        static int evenlyDivides(int n) {

            int count=0;

            //convert int to string
            String nToString = String.valueOf(n);

            //Convert string to string element array
            String[] strArr =  nToString.split("");

            //Convert array of String to int[] using stream API
            int[] intArr = Arrays.stream(strArr).
                    mapToInt(Integer::parseInt).toArray();

            //Convert array of String to ArrayList using stream API
            List<Integer> intList = Arrays.stream(strArr)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

                    //Conventional method
//                    int[] arr = new int[strArr.length];
//
//                    for(int i=0; i<intArr.length; i++){
//                        arr[i] = Integer.parseInt(strArr[i]);
//                    }

            for(int i=0; i<intArr.length; i++){
                if(intArr[i] != 0 && n%intArr[i] == 0)count++;
            }
            return count;
        }

        // 2
        static int reverse(int x) {

            long reversedNumber= 0;
            long number = Math.abs(x);

            while( number > 0 ){
                long lastDigit = number%10;
                reversedNumber = reversedNumber*10 + lastDigit;
                if(reversedNumber > Integer.MAX_VALUE ||
                        reversedNumber < Integer.MIN_VALUE){return 0;}
                number = number/10;
            }

            return (int) (x > 0 ? reversedNumber : -1 * reversedNumber);

    }

        // 3
        static boolean isPalindrome(int x) {

            //if -ve return false
            if( x < 0){return false;}

            int secondPointer = x;
            int thirdPointer = 0;

            //reverse number algorithm
            while(secondPointer != 0){
                thirdPointer = thirdPointer*10 + secondPointer%10;
                secondPointer = secondPointer/10;
            }

            return x == thirdPointer ? true : false;

    }

        // 4 GFG version
        static int[] lcmAndGcd(int a, int b) {

        // declarations
        int largerNumber; int smallestNumber;

        // find  largerNumber and smallestNumber
        largerNumber = (a > b) ?  a : b;
        smallestNumber = (a < b) ?  a : b;

        /*
        // using Math class
        largerNumber = Math.max(a, b);
        smallestNumber = Math.min(a, b);
        */

        // find gcd using formula
        int gcd = findGcd(largerNumber, smallestNumber);
        // find lcm using eucilidian formula
        int lcm = (largerNumber * smallestNumber)/ gcd;

        return new int[]{lcm, gcd};

    }

        static int findGcd(int largerNumber, int smallestNumber){

        int reminder = -1;

        while(reminder != 0){
            reminder = largerNumber % smallestNumber;
            largerNumber = smallestNumber;
            smallestNumber = reminder;
        }
        return largerNumber;
    }

        // 4 LeetCode version
        static String gcdOfStrings(String str1, String str2) {

            // Check problem description
            if( !(str1 + str2).equals(str2 + str1) ){ return ""; }

            // Set-up
            int largerLength = Math.max( str1.length() , str2.length() );
            int smallerLength = Math.min( str1.length() , str2.length() );
            int reminder = -1;

            // Find GCD using formula
            while( reminder != 0 ){
                reminder = largerLength % smallerLength;
                largerLength = smallerLength;
                smallerLength = reminder;
            }

            return str1.substring(0, largerLength);

        }

        // 5 Code ninjas
        static void armStrong(String[] args) {
            // Find number length
            Scanner sc = new Scanner(System.in);
            int n= sc.nextInt();

            // Write your code here
            String stringOfNumber = String.valueOf(n);
            int numberLength = stringOfNumber.length();

            // Intializations
            int sum = 0;
            int number = n;

            while(number != 0){
                sum = (int)( sum + Math.pow(number%10, numberLength) );
                number = number/10;
            }

            System.out.println(n == sum);

        }

        // 6 GFG
        static int sumOfDivisors(int n) {

        int sum= 0;

        //Loop
        for(int i=1; i<=n ;i++){

            int limit = (int)(Math.sqrt(i));

            for(int j=1; j<=limit; j++){

                if(i%j == 0){
                    sum += j;
                    if(j*j != i){sum += i/j; }
                    // Avoiding double entry of the square root value
                    // Check striver's explanation page [easy]
                }

            }

        }

        return sum;

        }

        // Curiosity led to
        static void seiveOfEratosthenes(int n){

            boolean[] isPrime = new boolean[n+1];
            isPrime[2] = isPrime[3] = true;
            int limit = (int) Math.sqrt(n);

            for(int i=1; i<=limit; i++){

                if(isPrime[i]){
                    seiveOfEratosthenesHelper(isPrime, n, i);
                }

            }

            System.out.println("The prime numbers upto- "+ n);

            // Since 1 is not a prime number, but a unit
            for(int i=2; i<=n; i++){
                if(!isPrime[i]){
                    System.out.print(i+ ", ");
                }
            }

        }

        static void seiveOfEratosthenesHelper
                (boolean[] isPrime, int n, int i){

            // j = i*i, because from i*2 to < i*i
            // is covered by previous non- prime elements
            // for 3*3 -> 6 is covered by other non-prime
            // elements like 2 which has number 4 in it
            // Multiples of i like 3,9,12...n
            for(int j=i*i; j<=n; j += i){
                isPrime[j] = true;
            }
        }

        // 7th problem skipped as it is
        // irrelevant to Striver's DSA sheet



        public  static void main(String[] args){
            seiveOfEratosthenes(25);
        }
    }

