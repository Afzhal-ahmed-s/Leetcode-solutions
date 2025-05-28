package com.notes.masai;

public class HDFC extends Bank{

    public HDFC(){
    System.out.println("HDFC statement in constructor!");
    }

    public int getRateOfInterest(){
        return 10;
    }

    public long getPinCode(){
        return 641038;
    }


    public void experiment(){
        System.out.println("HDFC");
    }
}
