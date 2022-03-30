package c.inheritance;

public class InheritanceCasting{
  public static void main(String args[]) {
    InheritanceCasting inheritance = new InheritanceCasting();
    //inheritance.objectCast();
    //inheritance.objectCast2();
    inheritance.objectCastArray();
    
  }
  
  public void objectCast () {
    ParentCasting parent = new ParentCasting();
    ChildCasting child = new ChildCasting();
    
    ParentCasting parent2 = child;
    ChildCasting child2 = (ChildCasting)parent;
    
  }
  
  
  public void objectCast2 () {
    
    ChildCasting child = new ChildCasting();
    ParentCasting parent2 = child;
    ChildCasting child2 = (ChildCasting)parent2;
    
  }
  
  public void objectCastArray() {
    ParentCasting[] parentArray = new ParentCasting[3];
    parentArray[0] = new ChildCasting();
    parentArray[1] = new ParentCasting();
    parentArray[2] = new ChildCasting();
    objectTypeCheck(parentArray);
  }
  
  private void objectTypeCheck(ParentCasting[] parentArray) {
    for(ParentCasting tempParent:parentArray) {
      //가장 하위에 있는 자식 타입부터 확인을 해야한다.
      if(tempParent instanceof ChildCasting) {
        System.out.println("ChildCasting");
        //정확하게 타입을 확인 후에 casting을 해주면 예외발생이 적다.
        ChildCasting tempChild = (ChildCasting)tempParent;
        tempChild.printAge();
      } else if(tempParent instanceof ParentCasting) {
        System.out.println("ParentCasting");
      }
    }
  }
  
  
}