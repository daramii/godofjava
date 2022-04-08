package c.inheritance;

public class ToString {
 
  public static void main(String args[]) {
    ToString thisObject = new ToString();
    thisObject.toStringMethod(thisObject);
    thisObject.toStringMethod2();
  }
  
  public void toStringMethod(Object obj) {
    System.out.println(obj);
    System.out.println(obj.toString());
    System.out.println("plus " + obj); //자동으로 toString으로 호출되서 String 값이 놓이게 된다.
  }
  
  //this를 사용하면 자신의 객체에 대한 참조를 한다.
  public void toStringMethod2() {
    System.out.println(this);
    System.out.println(toString());
    System.out.println("plus " + this); 
  }
  
  public String toString() {
    return "ToString class";
  }
  
}