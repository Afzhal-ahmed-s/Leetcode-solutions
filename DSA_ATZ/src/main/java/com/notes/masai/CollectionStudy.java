package com.notes.masai;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionStudy {

    public static void main(String[] args){

        // Create an array list
        ArrayList<Integer> al1 = new ArrayList<>();

        // Create a new list with elements
        List<Integer> al2 = Arrays.asList(1,2,3);

        // Create a new array list with elements
        ArrayList<Integer> al3 = new ArrayList<>( Arrays.asList(1,2,3) );

        // Add elements
        al1.add(1);
        al1.add(2);
        al1.add(3);
        al1.add(4);

        // Add multiple items in an existing list with items
        al1.addAll(Arrays.asList(5,6,7,8));

        // Enhanced for-loop
        for(Object e : al1){
            System.out.println(e);
        }

        // Check if an element is present in array list
        System.out.println(al1.contains(2));

        // Convert array list to object array
        Object[] obArr1 = al1.toArray();

        // Convert ArrayList to int[]
        int[] intArr1 = al2.stream().mapToInt(e -> e).toArray();

        // Convert ArrayList to Integer[]
        Integer[] IntegerArr1 = al2.toArray(new Integer[0]);

        // Using stream to print elements
        al1.stream().forEach(e -> System.out.println(e));

        // Using stream chain filter and collect to list
        al1.stream().filter(e -> e<= 5).collect(Collectors.toList());
    }

}
