package com.dsa.sheet.striver.stepone.learnthebasics;

import java.util.ArrayList;

///Learnings:
// Recursion
// Recursion body structuring using helper function
// Using pass by reference in recursion problems
// Using int as return type and not using
// pass by reference style of recursion
// Space complexity = Recursive call stack depth
// Time and space complexities varies kind of
// depending on the problem

// Regular expression to eliminate non-alpha numeric characters.
// string.replaceAll(sequence of characters or
// character or regex,
// new sequence of characters or character);
// T.C, S.C ? -> O(N), O(N)
// Factorial formula [mathematics]
// Palindrome logic [mathematics]
// Fibonacci logic [mathematics]
//

public class LectureFive {

    // 1 and 2
    static void printNos(int n) {

        helperprintNos(1, n);

    }

    static void helperprintNos(int i, int n) {

        // base condition
        if (i == n + 1) {
            return;
        }

        //operation
        System.out.print(i + " ");

        // recursion call
        helperprintNos(i + 1, n);

    }

    // 4
    static void printNos2(int N) {

        helperQFour(N);

    }

    static void helperQFour(int N) {

        // base case
        if (N == 0) {
            return;
        }

        // operation
        System.out.print(N + " ");

        // recursion call
        helperQFour(--N);

    }

    // 5 With int[] for pass by reference
    static int sumOfSeries(int n) {

        int[] arr = {0};

        helpersumOfSeries(1, n, arr);
        return arr[0];

    }

    static void helpersumOfSeries(int i, int N, int[] arr) {

        // base case
        if (i == N + 1) {
            return;
        }

        // operation
        arr[0] = arr[0] + (int) Math.pow(i, 3);

        // recursion call
        helpersumOfSeries(i+1, N, arr);

    }

    // 5 With helper function returning int value as result, no int[]
    // (pass by reference used)
    static int sumOfSeries2(int n) {
        int num = 0;
        num = helpersumOfSeries2(1, n, num);
        return num;
    }

    static int helpersumOfSeries2(int i, int N, int num) {
        // Base case
        if (i == N + 1) {
            return num;
        }

        // Operation
        num = num + (int) Math.pow(i, 3);

        // Recursion call
        return helpersumOfSeries2(i + 1, N, num);
    }

    // 6 T.C, S.C ? ->
    // k is the number of factorial numbers less than or equal to n
    // n is the input numberO(K*N), O(N)

    static ArrayList<Long> findfactorialNumbers(long n) {

        // intializations
        ArrayList<Long> list = new ArrayList<Long>();
        int i = 1;

        // find factorial of each number
        // check if it's lesser than N
        // if yes? -> add it to list, increment i
        // if no ? -> break the loop and return the list that we have at hand

        while(true){
            long factorialOfN = helperFindFactorialOfANumber(i, (long) 1);

            if(factorialOfN <= n){
                list.add(factorialOfN);
                i++;
            }
            else { break; }
        }

        return list;
    }

    static long helperFindFactorialOfANumber(int N, long factorial){

        // base condition
        if( N == 0){ return factorial; }

        // operation
        factorial = factorial * (long)N;

        // recursion call
        return helperFindFactorialOfANumber(--N, factorial);

    }

    // 7 T.C , S.C ? -> O(N), O(N)
    static void reverseArray(int arr[]) {

        helperReverseArray(0, arr, arr.length);

    }

    static void helperReverseArray(int index, int arr[], int length){

        // base condition
        if(index >= (int)(Math.floor(length / 2)) ){ return; }

        // operation
        int elementAtStart = arr[index];
        int elementAtEnd = arr[length - 1 - index];
        arr[index] = elementAtEnd;
        arr[length - 1 - index] = elementAtStart;

        // recuriosn call
        helperReverseArray(++index, arr, length);

    }

    // 8 T.C, S.C ? -> O(N), O(N)
    static boolean isPalindrome(String s) {

        // Remove the unnecessary elements
        String pureString = s.replaceAll
                ("[^a-zA-Z0-9]", "").toUpperCase();

        int length = pureString.length();

        // Check if string is empty
        if(length == 0){ return true; }

        return helperIsPalindrome(0, pureString, length);

    }

    static boolean helperIsPalindrome
            (int index, String pureString, int length){

        // Base case
        if(pureString.charAt(index) != pureString.charAt(length - 1 - index))
        { return false;}
        if(index >= length/2){ return true; }

        // Operation
        // one

        // Recursive call
        return helperIsPalindrome(++index, pureString, length);
    }

    // 9 T.C, S.C ? -> O(2^N), O(N)
    static int fib(int n) {

        // Base condition
        if( n <= 1){ return n; }

        // Operation
        // none

        // Recursion call
        return fib(n-1) + fib(n-2);
    }


    public static void main(String[] args) {

        System.out.println( findfactorialNumbers(30) );

    }

}
