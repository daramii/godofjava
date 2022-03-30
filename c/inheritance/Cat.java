package c.inheritance;

public class Cat extends Animal{

  String name;
  String kind;
  int legCount;
  int iq;
  boolean hasWing;
  
  public void move() {
    System.out.println("Cat move.");
  }
  
  public void eatFood() {
      System.out.println("Cat eat food.");
  }
  
  


}