/// Learnings

// Convert Array to List
// Convert Array to ArrayList
// Ways to create an array
// Ways to print an array
/*

        > Convert Array to List:
        List<DT> vn = List.of(new DT[arraySize]);
        List<DT> vn = Arrays.asList(originalArray);

        > Convert Array to ArrayList:
        ArrayList<DT> vn = new ArrayList<DT>( List.of(new DT[arraySize]) );

        > Ways to create an array:
            1. DT[] = new DT[arraySize];
            2. DT[] = {element, element, element};   (Note: Curly braces)

               DT[] vn = new DT[]{1, 2, 3, 4, 5};
            3. DT[] vn = Arrays.copyOf(originalArr, originalArr.length);
            4. DT[] vn = Arrays.copyOfRange(originalArr, starRange, endRange);

        > Ways to print an array:
            1. for( DT i=0; i<limit; i++){syso;)
            2. for(DT i: array){syso;}
            3. Arrays.steam(arraySourceVn).forEach(e -> System.out.println(e));
            4. Arrays.stream(arraySourceVn).forEach(System.out::println);

         */

// Convert an input string of integers separated by space to int[]
/*
    int[] arr = Arrays.stream( scanner.nextLine().split(" ") ).
                    mapToInt(Integer::parseInt).toArray();
     */

// Copy an array and variations
/*
        int[] originalArr = {1, 2, 3, 4, 5};
        int[] copiedArr = Arrays.copyOfRange(originalArr, 0, 4);
        int[] copiedArr2 = Arrays.copyOf(originalArr, originalArr.length);

        Arrays.stream(copiedArr).forEach(e -> System.out.println(e));
        Arrays.stream(copiedArr2).forEach(e -> System.out.println(e));

        Arrays.stream(originalArr).forEach(e -> System.out.println(e));
        Arrays.stream(originalArr).forEach(System.out::println);

*/

// Switch case
/*
            int i = 22;

            switch (i){
                case 1:
                    System.out.println("It's "+ 1);
                    break;
                case 2:
                    System.out.println("It's "+ 2);
                    break;
                case 3:
                    System.out.println("It's "+ 3);
                    break;
                default:
                    System.out.println("It's default");
            }
        */

// Time complexities
/*
Common time complexities

Let n be the main variable in the problem.

If n ≤ 12, the time complexity can be O(n!).
If n ≤ 25, the time complexity can be O(2n).
If n ≤ 100, the time complexity can be O(n4).
If n ≤ 500, the time complexity can be O(n3).
If n ≤ 10^4, the time complexity can be O(n2).
If n ≤ 10^6, the time complexity can be O(n log n).
If n ≤ 10^8, the time complexity can be O(n).
If n > 10^8, the time complexity can be O(log n) or O(1).
 */

// Pass by reference vs Pass by value [Deep and tricky]
/*
Let's break it down further:
Passing an Object to a Method
When you pass an object to a method, you're passing a
reference to that object. Think of this reference as a memory address.
What Happens in the Method
In the changeDog method:
A copy of the original reference (memory address) is created.
This copy is used to access the original object.
When you assign dog = new Dog("Buddy");, you're changing the
local copy of the reference to point to a new memory address,
 where the new Dog object is stored.
Key Point
The original reference (memory address) in the main method remains unchanged.
 It still points to the original Dog object.
 */

// Frequently used scanner class methods
/*
scanner.next();
scanner.nextInt();
scanner.nextLine();
scanner.nextDouble();
scanner.hasNext();
scanner.close();
 */

package com.dsa.sheet.striver.stepone.learnthebasics;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class LectureOne {

    // Takes all type of complex data
    static void inputTakingOne(){


        // Note:
        // Scanner object takes input from standard input stream,
        // which is a text based input stream, does not take input from mouse
        // In order to take input from mouse we can use GUI library like JavaFx

        // Problem-
        // Input format
        // n
        // a b
        // array number seperated by space
        // string that needs to be consumed as whole
        // string of words that need to seperated by space or any character

        // Note:
        // "\n" in a string brings in a new line

        String inputData = "2\n3 4\n1 2 3 4\nYou are loving this\n" +
                "The name is Afzhal Ahmed.\n3 5\n1 2 3 4 5\n" +
                "You are loving this sweetheart\nThe name is Amrin.";

//      System.out.println(inputData);
        Scanner scanner  = new Scanner(inputData);

        // In-order to get rid of the new line character after 'n'
        int n = scanner.nextInt();

        int a; int b;

        String inputOne;
        List<String> listOfString;
        scanner.nextLine();

        while(n>0){

            /*
            The "newline character" is a special character
            that indicates the end of a line of text.
            When you press the Enter key on your keyboard,
            you are inserting a newline character into the text.

            scanner.nextLine() call is reading and discarding the
            newline character that was left in the input buffer
            after reading an integer with scanner.nextInt().
             */

            a = scanner.nextInt(); b = scanner.nextInt();
            scanner.nextLine();
            //String[] stringOfNumbers = scanner.nextLine().split(" ");

            // Important
            // Conversion
            int[] arr = Arrays.stream( scanner.nextLine().split(" ") ).
                    mapToInt(Integer::parseInt).toArray();

            String str = scanner.nextLine();
            String[] stringOfWords = scanner.nextLine().split(" ");

            System.out.println(a +" "+ b +", stringOfNumbers: "+ arr
                    + ", str: "+ str +  ", stringOfWords: "+ stringOfWords);

            --n;

        }

    }

    // Takes complex integer data only as input data
    static void inputTakingTwo(){
        String inputData = "1\n 2 3 4\n 5 6 7\n 8 9 10 11";

        Scanner scanner = new Scanner(inputData);

        while(scanner.hasNextInt()){
            System.out.print(scanner.nextInt() + ", ");
        }

    }

    public static void main(String[] args){

         inputTakingOne();
//       inputTakingTwo();

    }

}
