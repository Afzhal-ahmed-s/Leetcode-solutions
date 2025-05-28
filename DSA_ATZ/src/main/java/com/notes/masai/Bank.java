package com.notes.masai;

public abstract class Bank {

    public Bank(){}

    public static String industry = "Banking";

    private long pinCode = 641030;
    public abstract int getRateOfInterest();

    public long getPinCode(){
        return pinCode;
    }

    public void experiment(){
        System.out.println("Bank");
    }


}
