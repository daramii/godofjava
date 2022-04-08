package c.javapackage;

//import c.javapackage.sub.SubStatic.subStaticMethod;
import static c.javapackage.sub.SubStatic.subStaticMethod;
import static c.javapackage.sub.SubStatic.CLASS_NAME;
//�����ٷ� �Է��ϱ� �������� �׳�
//import static c.java.package.sub.SubStatic.*;

public class PackageStatic {
  public static void main(String[] args) {
    
    //SubStatic.subStaticMethod();
    subStaticMethod(); //static���� import�� ��쿡�� ��������� �������ʿ����.
    //System.out.println(SubStatic.CLASS_NAME);
    System.out.println(CLASS_NAME);
    
  }
}