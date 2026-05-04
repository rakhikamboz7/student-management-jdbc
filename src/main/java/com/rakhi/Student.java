package com.rakhi;

public class Student {
//No outside class should directly modify internal data carelessly.
    private final int id;
    private String name;
    private int age;
//input values sent during object creation

//    @Override
//    public String toString() {
//        return "ID: " + id + ", Name: " + name + ", Age: " + age;
//    }
    public Student(int id, String name, int age) { //special method used automatically when object is created
        this.id = id;  //  left side this.id means object's creation, right side means parameter creation
        this.name= name;  //we used this because parameters and field names are same
        this.age = age;
    }
    //Getter-commonly used to retrieve private field values while preserving encapsulation.
    public int getId() {
        return id;
    }
    //Setters - used to update/change value-modify private fields in a controlled way
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public void showDetails() {
//        System.out.println("ID: "+ id);
//        System.out.println("Name: "+ name );
//        System.out.println("Age: "+ age);
//        System.out.println("---------******-------");
//        System.out.println(this);
//        System.out.println("---------******-------");
//    }


}
