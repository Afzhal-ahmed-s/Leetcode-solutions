package com.notes.masai;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    System.out.println("Afzhal here.");

//    //Ways to initialize an array
//     int[] arr1 = {0, 1, 2, 3, 4};
//     int[] arr2 = new int[5];

//     //ways to write for loop
//     for(int i=0; i<arr1.length; i++){
//         System.out.println("Hey person "+ arr1[i]);
//     }
//
//     for(int element: arr1){
//         System.out.println(element);
//     }

        Animal animal1 = new Lion("Simba", 20);
        Lion lion1  = (Lion) animal1;
        lion1.getDetails();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name: ");
        String name = scanner.nextLine();

        System.out.println("Enter any 5 number seperated by space: ");
        String[] arr3 = scanner.nextLine().split(" ");

        int[] arr4 = new int[arr3.length];

        for(int i=0; i<arr3.length; i++){
            arr4[i] = Integer.parseInt(arr3[i]);
        }

        for( int e : arr4){ System.out.println(e); }
    }
}