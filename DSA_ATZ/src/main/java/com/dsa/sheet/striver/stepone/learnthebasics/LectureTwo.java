package com.dsa.sheet.striver.stepone.learnthebasics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LectureTwo {

    //Un-optimized
    //T.C: O(N^2), S.C: O(1)
    public static void striverQuestion9(int n){

        /*
        Question 9:
        Pattern:
           *
          ***
         *****
          ***
           *

         */

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void striverQuestion12(int n){

    /*
    Question 12:

    Input Format: N = 6
    Result:
    1          1
    12        21
    123      321
    1234    4321
    12345  54321
    123456654321
    */

        for (int i = 0; i < n; i++){

            for(int j = 0; j <= i; j++) System.out.print(j+1);
            for(int j = i+1; j < n; j++) System.out.print(" ");
            for(int j = n; j < ((2*n)-(i+1)); j++) System.out.print(" ");
            for(int j = (2*n)-1-i; j < (2*n); j++) System.out.print( (2*n)-j );

            System.out.println();
        }
    }

    public static void kunalQuestion17_ap1(int n){


            /*
            Question from Kunal Kushawa:

            N=4
                 1
                212
               32123
              4321234
               32123
                212
                 1
             */

        for(int row= 1; row <= n; row++){

            for(int col= 1; col <= n-row; col++){
                System.out.print(" ");
            }
            for(int col= ((n+1)-row) ; col <= n; col++){
                System.out.print(n-col+1);
            }
            for(int col= n+1; col < n+row; col++ ){
                System.out.print(col-n+1);
            }

            System.out.println();
        }

        for(int row= n+1; row < 2*n; row++){

            for(int col=1; col <= row- n; col++){
                System.out.print(" ");
            }
            for(int col= row-n+1; col <= n; col++){
                System.out.print(n-col+1);
            }
            for(int col= n+1; col < (3*n)-row; col++ ){
                System.out.print(col-n+1);
            }

            System.out.println();
        }

    }

    //Optimized
    // T.C: O(N^2), S.C: O(1)
    public static void striverQuestion17(int n){

    /*
    Question 17:

    Input Format: N = 6
    Result:
         A
        ABA
       ABCBA
      ABCDCBA
     ABCDEDCBA
    ABCDEFEDCBA
    */

        for (int row = 1; row<= n; row++){

            //spaces
            for (int col = 1; col<=n-row; col++){
                System.out.print(" ");
            }

            //left
            for (int col=0; col<row; col++) {
                System.out.print((char) ('A' + col));
            }
            //right
            for (int col=row-1; col>=1; col--){
                System.out.print((char) ('A' + col-1));
            }
            //next line
            System.out.println();
        }


    }

    //Optimized
    // T.C: O(N^2), S.C: O(1)
    public static void kunalQuestion17_ap2(int n) {

            /*
            Question from Kunal Kushawa:

            N=4
                 1
                212
               32123
              4321234
               32123
                212
                 1
             */

        for(int row = 1; row < 2*n; row++){

            int spaces = row <= n ? n-row : row-n;
            int c = row <= n ? row : ((2*n) - row);

            //spaces
            for(int col= 1; col<=spaces; col++){
                System.out.print(" ");
            }
            //left side
            for(int col= c; col>=1; col--){
                System.out.print(col);
            }
            //right side
            for(int col=2; col <= c; col++){
                System.out.print(col);
            }
            //next line
            System.out.println();

        }

    }

    public static void striverQuestion22(int n){
    /*
    Input Format: N = 3
    Result:
    3 3 3 3 3
    3 2 2 2 3
    3 2 1 2 3
    3 2 2 2 3
    3 3 3 3 3

    Input Format: N = 6
    Result:
    6 6 6 6 6 6 6 6 6 6 6
    6 5 5 5 5 5 5 5 5 5 6
    6 5 4 4 4 4 4 4 4 5 6
    6 5 4 3 3 3 3 3 4 5 6
    6 5 4 3 2 2 2 3 4 5 6
    6 5 4 3 2 1 2 3 4 5 6
    6 5 4 3 2 2 2 3 4 5 6
    6 5 4 3 3 3 3 3 4 5 6
    6 5 4 4 4 4 4 4 4 5 6
    6 5 5 5 5 5 5 5 5 5 6
    6 6 6 6 6 6 6 6 6 6 6
     */

        for (int row = 1; row < 2*n; row++) {

            int distanceFromTop = row-1;
            int distanceFromBottom = (2*n) -1 - row;
            int distanceFromLeft; int distanceFromRight;

            for(int col=1; col<2*n; col++) {
                distanceFromLeft = col-1;
                distanceFromRight = (2 * n) - 1 - col;

                System.out.print( n- (Math.min( Math.min(distanceFromLeft,
                        distanceFromRight), Math.min(distanceFromTop,
                        distanceFromBottom) )) + " ");
            }
            //nextLine
            System.out.println();
        }
    }


    public static void main(String[] args) {

        //striverQuestion17(7);
        //striverQuestion22(9);
    }

}


