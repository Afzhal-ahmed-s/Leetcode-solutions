package com.dsa.sheet.striver.stepone.learnthebasics;

import com.notes.masai.Lion;

import java.util.*;

//// Learnings
// Map, Hashmap their methods
// getOrDefault(keyValue, 0) + 1
// Converts int[] to Integer[]
// Arrays.stream(arr).boxed().collect(Collectors.toList());
// Enhanced for loop

// Convert Map to entrySet()

public class LectureSix {

    static List<Integer> frequencyCount(int[] arr) {

        Map<Integer, Integer> map= new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<Integer>();


        // for( int e : arr){
        //     if(map.containsKey(e)){ map.put( e, map.get(e)+1 ); }
        //     else { map.put(e, 1); }
        // }

        for( int e : arr){
            map.put(e, map.getOrDefault(e, 0) + 1);
        }

        for(int i=0; i<arr.length; i++){
            if(map.containsKey(i+1)){
                list.add(i, map.get(i+1));
            }
            else list.add(i, 0);
        }

        // List<Integer> list =
        // Arrays.stream(arr).boxed().collect(Collectors.toList());
        return list;


    }

    static void highestLowestElement(int[] arr){

        if(arr.length == 0){
            System.out.println("Invalid: Empty array.");
            return;
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxCount = 0;
        int minCount = 1;

        for( int e: arr){
            map.put( e, map.getOrDefault(e, 0) + 1);
            maxCount = Math.max(maxCount, map.get(e));
            minCount = Math.min(minCount, map.get(e));
        }

        System.out.println(map+ " "+ maxCount + " " + minCount);

        Set<Map.Entry<Integer, Integer>> set= map.entrySet();
        List<Integer> maxFrequencyElemnts = new ArrayList<Integer>();
        List<Integer> minFrequencyElemnts = new ArrayList<Integer>();

        for( Map.Entry<Integer, Integer> e : set){
            if(e.getValue() == maxCount){ maxFrequencyElemnts.add(e.getKey()); }
            if(e.getValue() == minCount){ minFrequencyElemnts.add(e.getKey()); }
        }

        System.out.println("The maximum frequency elements: ");
        for( Integer e : maxFrequencyElemnts){ System.out.print(e + " ");}

        System.out.println();

        System.out.println("The minimum frequency elements: ");
        for( Integer e : minFrequencyElemnts){ System.out.print(e + " ");}

    }




    public static void main(String[] args){

        highestLowestElement(new int[]{});
    }

}
