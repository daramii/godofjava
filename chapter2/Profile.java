public class Profile {
  
  String name;
  int age;
  
  public static void main (String [] args) {
    //System.out.println("My name is Kim Dasol.");
    //System.out.println("My age is 30.");
    
    Profile pf = new Profile();
    pf.setName("Min");
    pf.setAge(20);
    pf.printName();
    pf.printAge();
    
    
  }
  
  
  public void setName(String str) {
    name = str;  
  }
  
  
  public void setAge(int val) {
   age = val; 
  }
  
  public void printName() {
   System.out.println("My name is " + name); 
  }
  
  public void printAge() {
   System.out.println("My age is " + age); 
  }
  
}