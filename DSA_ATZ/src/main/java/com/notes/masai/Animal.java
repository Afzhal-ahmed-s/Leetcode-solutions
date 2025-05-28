package com.notes.masai;

public class Animal {

    private String name;
    private int age;

    public Animal(){

    }

    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName()
    {return this.name;}

    public int getAge()
    {return this.age;}

    public String roar(){
        return "Roar!!!";
    }

    public static String growl(){
        return "Growl!!!";
    }
}
