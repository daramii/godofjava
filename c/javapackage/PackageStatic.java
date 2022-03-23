package c.javapackage;

//import c.javapackage.sub.SubStatic.subStaticMethod;
import static c.java.package.sub.SubStatic.subStaticMethod;
import static c.java.package.sub.SubStatic.CLASS_NAME;
//여러줄로 입력하기 귀찮으면 그냥
//import static c.java.package.sub.SubStatic.*; 이렇게 하면 된다.

public class PackageStatic {
  public static void main(String[] args) {
    
    //SubStatic.subStaticMethod();
    subStaticMethod(); //static으로 import한 경우에는 명시적으로 지정이필요없다.
    //System.out.println(SubStatic.CLASS_NAME);
    System.out.println(CLASS_NAME);
    
  }
}