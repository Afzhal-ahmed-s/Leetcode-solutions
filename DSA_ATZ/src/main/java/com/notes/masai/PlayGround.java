package com.notes.masai;

public class PlayGround {

    public static void main(String[] args){
        Bank bank1 = new HDFC();
        System.out.println( bank1.getRateOfInterest() );

        Bank bank2 = new ICICI();
        System.out.println( bank2.getRateOfInterest() );

        System.out.println(bank1.getPinCode());

        System.out.println(Bank.industry);

        bank1.experiment();

        HDFC hdfcBank = (HDFC) bank1;
        bank1.experiment();
        hdfcBank.experiment();

        Bike bike1 = new PassionPro();
        bike1.run();
    }
}
