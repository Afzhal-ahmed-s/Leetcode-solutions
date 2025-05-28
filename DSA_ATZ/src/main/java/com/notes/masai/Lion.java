package com.notes.masai;

public class Lion extends Animal{

    Animal animal1;

    public Lion(){
        this.animal1 = new Animal();
    }

    public Lion(String name, int age){
        this.animal1 = new Animal(name, age);
    }

    public void getDetails(){
        System.out.println(Animal.growl());
        System.out.println(animal1.roar());
    }





}
