package c.inheritance;

public class Dog extends Animal{

  String name;
  String kind;
  int legCount;
  int iq;
  boolean hasWing;
  
  public void move() {
    System.out.println("Dog move.");
  }
  
  public void eatFood() {
      System.out.println("Dog eat food.");
  }
  
  


}